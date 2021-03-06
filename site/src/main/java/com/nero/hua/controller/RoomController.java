package com.nero.hua.controller;

import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.model.room.JoinRoomRequest;
import com.nero.hua.model.room.LeaveRoomRequest;
import com.nero.hua.model.user.ChangeUserPrepareStatusRequest;
import com.nero.hua.model.user.RoomUserInformationResponse;
import com.nero.hua.service.RoomService;
import com.nero.hua.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("create")
    public BaseResponse<Long> createRoom(HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);

        Long roomId = roomService.createRoom(userId);

        return new BaseResponse<>(roomId);
    }

    @PostMapping("join")
    public BaseResponse<Boolean> joinRoom(@RequestBody @Validated JoinRoomRequest joinRoomRequest,  HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);

        Boolean joinSuccess = roomService.joinRoom(userId, joinRoomRequest);

        return new BaseResponse<>(joinSuccess);
    }

    @PostMapping("leave")
    public BaseResponse<Boolean> leaveRoom(@RequestBody @Validated LeaveRoomRequest leaveRoomRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);

        Boolean joinSuccess = roomService.leaveRoom(userId, leaveRoomRequest);

        return new BaseResponse<>(joinSuccess);
    }

    @PostMapping("changeUserPrepareStatus")
    public BaseResponse<Boolean> changeUserPrepareStatus(@RequestBody @Validated ChangeUserPrepareStatusRequest changeUserPrepareStatusRequest, HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);

        Boolean joinSuccess = roomService.changeUserPrepareStatus(userId, changeUserPrepareStatusRequest);

        return new BaseResponse<>(joinSuccess);
    }

    @PostMapping("userList")
    public BaseResponse<List<RoomUserInformationResponse>> getRoomUserList(HttpServletRequest httpServletRequest) {
        String userId = LoginUtil.parseUserIdFromHttpServletRequest(httpServletRequest);

        List<RoomUserInformationResponse> roomUserInformationResponseList = roomService.getRoomUserList(userId);

        return new BaseResponse<>(roomUserInformationResponseList);
    }

}
