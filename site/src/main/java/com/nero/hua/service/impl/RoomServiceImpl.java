package com.nero.hua.service.impl;

import com.nero.hua.convert.UserConvert;
import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.room.JoinRoomRequest;
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

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserJoinRoomMessage userJoinRoomMessage = new UserJoinRoomMessage(userId);
        webSocketServer.sendMessage(allOtherUserList, userJoinRoomMessage);

        return Boolean.TRUE;
    }

    @Override
    public Boolean leaveRoom(String userId) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.leaveUser(userId);

        if (roomMO.empty()) {
            roomMOMap.remove(roomMO.getRoomId());
        }

        userIdRoomIdMap.remove(userId, roomMO.getRoomId());

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserLeaveRoomMessage userLeaveRoomMessage = new UserLeaveRoomMessage(userId);
        webSocketServer.sendMessage(allOtherUserList, userLeaveRoomMessage);

        return Boolean.TRUE;
    }

    private RoomMO findRoomByUserId(String userId) {
        Long roomId = userIdRoomIdMap.get(userId);
        if (null == roomId) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        RoomMO roomMO = roomMOMap.get(roomId);
        if (null == roomMO) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }
        return roomMO;
    }

    @Override
    public Boolean changeUserPrepareStatus(String userId, ChangeUserPrepareStatusRequest changeUserPrepareStatusRequest) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.changeUserPrepareStatus(userId, changeUserPrepareStatusRequest.getPrepared());

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        ChangeUserPrepareStatusMessage changeUserPrepareStatusMessage = new ChangeUserPrepareStatusMessage(userId, changeUserPrepareStatusRequest.getPrepared());
        webSocketServer.sendMessage(allOtherUserList, changeUserPrepareStatusMessage);

        if (roomMO.shouldNotStartGame()) {
            return Boolean.TRUE;
        }

        roomMO.startGame();

        List<GameUserMO> gameUserMOList = roomMO.getGameUserMOList();
        for (GameUserMO gameUserMO : gameUserMOList) {
            DealCardMessage dealCardMessage = new DealCardMessage(CardUtil.convertCardMapToCardList(gameUserMO.getCardMap()));
            webSocketServer.sendMessage(gameUserMO.getUserId(), dealCardMessage);
        }

        List<String> allUserList = roomMO.getAllUserList();
        String randomUserId = roomMO.chooseOneUserToRobLandlord();
        UserStartRobLandlordMessage userStartRobLandlordMessage = new UserStartRobLandlordMessage(randomUserId);
        webSocketServer.sendMessage(allUserList, userStartRobLandlordMessage);

        return Boolean.TRUE;
    }

    @Override
    public List<RoomUserInformationResponse> getRoomUserList(String userId) {
        RoomMO roomMO = findRoomByUserId(userId);

        return UserConvert.convertMoToResponse(roomMO.getGameUserMOList());
    }

    @Override
    public Boolean doRobLandlord(String userId) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.doRob(userId);

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserDoRobLandlordMessage userDoRobLandlordMessage = new UserDoRobLandlordMessage(userId);
        webSocketServer.sendMessage(allOtherUserList, userDoRobLandlordMessage);

        List<String> allUserList = roomMO.getAllUserList();
        List<CardEnumeration> landlordCardList = roomMO.getLandlordCardList();
        DealLandlordCardMessage dealLandlordCardMessage = new DealLandlordCardMessage(userId, landlordCardList);
        webSocketServer.sendMessage(allUserList, dealLandlordCardMessage);

        roomMO.giveLandlordCardToThisGuy(userId);

        UserStartToPlayCardMessage userStartToPlayCardMessage = new UserStartToPlayCardMessage(userId);
        webSocketServer.sendMessage(allUserList, userStartToPlayCardMessage);

        return Boolean.TRUE;
    }

    @Override
    public Boolean doNotRobLandlord(String userId) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.doNotRob(userId);

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserDoNotRobLandlordMessage userDoNotRobLandlordMessage = new UserDoNotRobLandlordMessage(userId);
        webSocketServer.sendMessage(allOtherUserList, userDoNotRobLandlordMessage);

        List<String> allUserList = roomMO.getAllUserList();
        if (roomMO.hasNextOneToStartRob()) {
            String nextUserIdToStartRob = roomMO.makeNextUserToStartRob();
            UserStartRobLandlordMessage userStartRobLandlordMessage = new UserStartRobLandlordMessage(nextUserIdToStartRob);
            webSocketServer.sendMessage(allUserList, userStartRobLandlordMessage);
        }
        else {
            String lastUserId = roomMO.makeLastUserRobLandlordCard();
            List<CardEnumeration> landlordCardList = roomMO.getLandlordCardList();
            DealLandlordCardMessage dealLandlordCardMessage = new DealLandlordCardMessage(lastUserId, landlordCardList);
            webSocketServer.sendMessage(allUserList, dealLandlordCardMessage);

            roomMO.giveLandlordCardToThisGuy(lastUserId);

            UserStartToPlayCardMessage userStartToPlayCardMessage = new UserStartToPlayCardMessage(lastUserId);
            webSocketServer.sendMessage(allUserList, userStartToPlayCardMessage);
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean doPlayCard(String userId, UserDoPlayCardRequest userDoPlayCardRequest) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.doPlayCard(userId, userDoPlayCardRequest.getCardEnumerationList(), userDoPlayCardRequest.getPlayCardTypeEnumeration());

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserDoPlayCardMessage userDoPlayCardMessage = new UserDoPlayCardMessage(userId, userDoPlayCardRequest.getCardEnumerationList(), userDoPlayCardRequest.getPlayCardTypeEnumeration());
        webSocketServer.sendMessage(allOtherUserList, userDoPlayCardMessage);

        List<String> allUserList = roomMO.getAllUserList();
        if (roomMO.thisGuyWin(userId)) {
            UserWinMessage userWinMessage = new UserWinMessage(userId);
            webSocketServer.sendMessage(allUserList, userWinMessage);
        }
        else {
            String nextUserId = roomMO.makeNextUserToStartPlayCard();
            UserStartToPlayCardMessage userStartToPlayCardMessage = new UserStartToPlayCardMessage(nextUserId);
            webSocketServer.sendMessage(allUserList, userStartToPlayCardMessage);
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean doNotPlayCard(String userId) {
        RoomMO roomMO = findRoomByUserId(userId);

        roomMO.doNotPlayCard(userId);

        List<String> allOtherUserList = roomMO.getAllOtherUserList(userId);
        UserDoNotPlayCardMessage userDoNotPlayCardMessage = new UserDoNotPlayCardMessage(userId);
        webSocketServer.sendMessage(allOtherUserList, userDoNotPlayCardMessage);

        List<String> allUserList = roomMO.getAllUserList();
        if (roomMO.hasNextOneToStartPlayCard()) {
            String nextUserId = roomMO.makeNextUserToStartPlayCard();
            UserStartToPlayCardMessage userStartToPlayCardMessage = new UserStartToPlayCardMessage(nextUserId);
            webSocketServer.sendMessage(allUserList, userStartToPlayCardMessage);
        }
        else {
            String lastPlayCardUserId = roomMO.makeLastPlayCardUserToStartPlayCard();
            UserStartToPlayCardMessage userStartToPlayCardMessage = new UserStartToPlayCardMessage(lastPlayCardUserId);
            webSocketServer.sendMessage(allUserList, userStartToPlayCardMessage);
        }

        return Boolean.TRUE;
    }

}
