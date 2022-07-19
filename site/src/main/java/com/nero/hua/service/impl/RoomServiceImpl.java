package com.nero.hua.service.impl;

import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;
import com.nero.hua.model.room.RoomMO;
import com.nero.hua.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomServiceImpl implements RoomService {

    Map<Long, RoomMO> roomMOMap = new ConcurrentHashMap<>();
    Map<String, Long> userIdRoomIdMap= new ConcurrentHashMap<>();

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

        return Boolean.TRUE;
    }

}
