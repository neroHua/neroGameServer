package com.nero.hua.model.room;

import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.user.GameUserMO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Setter
@Getter
public class RoomMO {

    private static int MAX_USER_COUNT = 3;

    private Long roomId;

    private GameManager gameManager;

    private List<GameUserMO> gameUserMOList = new ArrayList<>();

    public void joinUser(String userId) {
        if (gameUserMOList.size() > MAX_USER_COUNT) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        GameUserMO gameUserMO = new GameUserMO();
        gameUserMO.setUserId(userId);
        gameUserMOList.add(gameUserMO);
    }

    public void leaveUser(String userId) {
        if (null == gameUserMOList) {
            return;
        }

        Iterator<GameUserMO> iterator = gameUserMOList.iterator();
        while (iterator.hasNext()) {
            GameUserMO next = iterator.next();
            if (userId.equals(next.getUserId())) {
                iterator.remove();
                break;
            }
        }
    }

    public boolean empty() {
        return null == gameUserMOList ? Boolean.TRUE : CollectionUtils.isEmpty(gameUserMOList);
    }

}
