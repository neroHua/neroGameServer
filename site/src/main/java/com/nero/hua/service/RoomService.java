package com.nero.hua.service;

import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;
import com.nero.hua.model.user.ChangeUserPrepareStatusRequest;
import com.nero.hua.model.user.RoomUserInformationResponse;

import java.util.List;

public interface RoomService {

    Long createRoom(String userId);

    Boolean joinRoom(String userId, JoinRoomRequest joinRoomRequest);

    Boolean leaveRoom(String userId, LeaveRoomRequest leaveRoomRequest);

    Boolean changeUserPrepareStatus(String userId, ChangeUserPrepareStatusRequest changeUserPrepareStatusRequest);

    List<RoomUserInformationResponse> getRoomUserList(String userId);

    Boolean doRobLandlord(String userId);

    Boolean doNotRobLandlord(String userId);
}
