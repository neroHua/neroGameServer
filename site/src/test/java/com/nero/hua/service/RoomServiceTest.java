package com.nero.hua.service;

import com.nero.hua.SiteApplication;
import com.nero.hua.model.room.JoinRoomRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("dev")
@SpringBootTest(classes = { SiteApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void testCreateAndJoinRoom() {
        long roomId = roomService.createRoom("testUserId");
        JoinRoomRequest joinRoomRequest = new JoinRoomRequest();
        joinRoomRequest.setRoomId(roomId);
        Boolean joinRoomSuccess = roomService.joinRoom("testUserId", joinRoomRequest);
        Assert.assertTrue(joinRoomSuccess);
    }

}
