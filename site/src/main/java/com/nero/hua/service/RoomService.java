package com.nero.hua.service;

import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;
import com.nero.hua.model.user.ChangeUserPrepareStatusRequest;

public interface RoomService {

    Long createRoom(String userId);

    Boolean joinRoom(String userId, JoinRoomRequest joinRoomRequest);

    Boolean leaveRoom(String userId, LeaveRoomRequest leaveRoomRequest);

    Boolean changeUserPrepareStatus(String userId, ChangeUserPrepareStatusRequest changeUserPrepareStatusRequest);
}
