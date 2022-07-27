package com.nero.hua.service.impl;

import com.nero.hua.convert.UserConvert;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;
import com.nero.hua.model.room.RoomMO;
import com.nero.hua.model.user.*;
import com.nero.hua.service.RoomService;
import com.nero.hua.util.CardUtil;
import com.nero.hua.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private WebSocketServer webSocketServer;

    private Map<Long, RoomMO> roomMOMap = new ConcurrentHashMap<>();
    private Map<String, Long> userIdRoomIdMap= new ConcurrentHashMap<>();

    @Override
    public Long createRoom(String userId) {
        RoomMO roomMO = new RoomMO();
        roomMO.setGameManager(new GameManager());
        roomMO.setRoomId((long) (roomMO.hashCode() % 1000));
        roomMOMap.put(roomMO.getRoomId(), roomMO);

        return roomMO.getRoomId();
    }

    @Override
    public Boolean joinRoom(String userId, JoinRoomRequest joinRoomRequest) {
        RoomMO roomMO = roomMOMap.get(joinRoomRequest.getRoomId());
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        roomMO.joinUser(userId);

        userIdRoomIdMap.put(userId, roomMO.getRoomId());

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        if (gameUserMOList.size() > 1) {
            UserJoinRoomMessage userJoinRoomMessage = new UserJoinRoomMessage(userId);
            for (GameUserMO gameUserMO : gameUserMOList) {
                if (!gameUserMO.getUserId().equals(userId)) {
                    webSocketServer.sendMessage(gameUserMO.getUserId(), userJoinRoomMessage);
                }
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean leaveRoom(String userId, LeaveRoomRequest leaveRoomRequest) {
        RoomMO roomMO = roomMOMap.get(leaveRoomRequest.getRoomId());
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        roomMO.leaveUser(userId);

        if (roomMO.empty()) {
            roomMOMap.remove(roomMO.getRoomId());
        }

        userIdRoomIdMap.remove(userId, roomMO.getRoomId());

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        if (gameUserMOList.size() > 1) {
            UserLeaveRoomMessage userLeaveRoomMessage = new UserLeaveRoomMessage(userId);
            for (GameUserMO gameUserMO : gameUserMOList) {
                if (!gameUserMO.getUserId().equals(userId)) {
                    webSocketServer.sendMessage(gameUserMO.getUserId(), userLeaveRoomMessage);
                }
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean changeUserPrepareStatus(String userId, ChangeUserPrepareStatusRequest changeUserPrepareStatusRequest) {
        Long roomId = userIdRoomIdMap.get(userId);
        if (null == roomId) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        RoomMO roomMO = roomMOMap.get(roomId);
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }
        roomMO.changeUserPrepareStatus(userId, changeUserPrepareStatusRequest.getPrepared());

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        if (gameUserMOList.size() > 1) {
            ChangeUserPrepareStatusMessage changeUserPrepareStatusMessage = new ChangeUserPrepareStatusMessage(userId, changeUserPrepareStatusRequest.getPrepared());
            for (GameUserMO gameUserMO : gameUserMOList) {
                if (!gameUserMO.getUserId().equals(userId)) {
                    webSocketServer.sendMessage(gameUserMO.getUserId(), changeUserPrepareStatusMessage);
                }
            }
        }

        if (roomMO.shouldNotStartGame()) {
            return Boolean.TRUE;
        }

        roomMO.startGame();
        gameUserMOList = roomMO.getGameUserMOList();
        for (GameUserMO gameUserMO : gameUserMOList) {
            DealCardMessage dealCardMessage = new DealCardMessage(CardUtil.convertCardMapToCardList(gameUserMO.getCardMap()));
            webSocketServer.sendMessage(gameUserMO.getUserId(), dealCardMessage);
        }

        String randomUserId = roomMO.chooseOneUserToRobLandlord();
        UserStartRobLandlordMessage userStartRobLandlordMessage = new UserStartRobLandlordMessage(randomUserId);
        for (GameUserMO gameUserMO : gameUserMOList) {
            webSocketServer.sendMessage(gameUserMO.getUserId(), userStartRobLandlordMessage);
        }

        return Boolean.TRUE;
    }

    @Override
    public List<RoomUserInformationResponse> getRoomUserList(String userId) {
        Long roomId = userIdRoomIdMap.get(userId);
        if (null == roomId) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        RoomMO roomMO = roomMOMap.get(roomId);
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        return UserConvert.convertMoToResponse(roomMO.getGameUserMOList());
    }

    @Override
    public Boolean doRobLandlord(String userId) {
        Long roomId = userIdRoomIdMap.get(userId);
        if (null == roomId) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        RoomMO roomMO = roomMOMap.get(roomId);
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        roomMO.thisGuyTurnToRob(userId);

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        UserDoRobLandlordMessage userDoRobLandlordMessage = new UserDoRobLandlordMessage(userId);
        for (GameUserMO gameUserMO : gameUserMOList) {
            if (!gameUserMO.getUserId().equals(userId)) {
                webSocketServer.sendMessage(gameUserMO.getUserId(), userDoRobLandlordMessage);
            }
        }

        List<CardEnumeration> landlordCardList = roomMO.getLandlordCardList();
        DealLandlordCardMessage dealLandlordCardMessage = new DealLandlordCardMessage(userId, landlordCardList);
        for (GameUserMO gameUserMO : gameUserMOList) {
            webSocketServer.sendMessage(gameUserMO.getUserId(), dealLandlordCardMessage);
        }

        roomMO.giveLandlordCardToThisGuy(userId);

        return Boolean.TRUE;
    }

    @Override
    public Boolean doNotRobLandlord(String userId) {
        Long roomId = userIdRoomIdMap.get(userId);
        if (null == roomId) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        RoomMO roomMO = roomMOMap.get(roomId);
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        roomMO.thisGuyTurnToNotRob(userId);

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        UserDoNotRobLandlordMessage userDoNotRobLandlordMessage = new UserDoNotRobLandlordMessage(userId);
        for (GameUserMO gameUserMO : gameUserMOList) {
            if (!gameUserMO.getUserId().equals(userId)) {
                webSocketServer.sendMessage(gameUserMO.getUserId(), userDoNotRobLandlordMessage);
            }
        }

        if (roomMO.hasNextOneToStartRob()) {
            String nextUserIdToStartRob = roomMO.getNextOneToStartRob();
            UserStartRobLandlordMessage userStartRobLandlordMessage = new UserStartRobLandlordMessage(nextUserIdToStartRob);
            for (GameUserMO gameUserMO : gameUserMOList) {
                webSocketServer.sendMessage(gameUserMO.getUserId(), userStartRobLandlordMessage);
            }
        }
        else {
            String lastUserId = roomMO.getLastUser();
            List<CardEnumeration> landlordCardList = roomMO.getLandlordCardList();
            DealLandlordCardMessage dealLandlordCardMessage = new DealLandlordCardMessage(lastUserId, landlordCardList);
            for (GameUserMO gameUserMO : gameUserMOList) {
                webSocketServer.sendMessage(gameUserMO.getUserId(), dealLandlordCardMessage);
            }

            roomMO.giveLandlordCardToThisGuy(userId);
        }

        return Boolean.TRUE;
    }

}
