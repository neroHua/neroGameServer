package com.nero.hua.service;

import com.nero.hua.SiteApplication;
import com.nero.hua.enumeration.GameTypeEnumeration;
import com.nero.hua.model.room.CreateRoomRequest;
import com.nero.hua.model.room.JoinRoomRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("dev")
@SpringBootTest(classes = { SiteApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @Test
    public void testCreateAndJoinRoom() {
        CreateRoomRequest createRoomRequest = new CreateRoomRequest();
        createRoomRequest.setGameTypeEnumeration(GameTypeEnumeration.FIGHT_LANDLORD_FOR_THREE);

        long roomId = roomService.createRoom(createRoomRequest, "testUserId");
        JoinRoomRequest joinRoomRequest = new JoinRoomRequest();
        joinRoomRequest.setRoomId(roomId);
        Boolean joinRoomSuccess = roomService.joinRoom("testUserId", joinRoomRequest);
        assertTrue(joinRoomSuccess);
    }

}
