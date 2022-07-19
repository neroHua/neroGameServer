package com.nero.hua.service;

import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;

public interface RoomService {

    Long createRoom(String userId);

    Boolean joinRoom(String userId, JoinRoomRequest joinRoomRequest);

    Boolean leaveRoom(String userId, LeaveRoomRequest leaveRoomRequest);
}
