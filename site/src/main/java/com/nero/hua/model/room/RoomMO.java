package com.nero.hua.model.room;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.user.GameUserMO;
import com.nero.hua.model.user.RobLandlordMO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class RoomMO {

    private Long roomId;

    private GameManager gameManager;

    private List<GameUserMO> gameUserMOList = new ArrayList<>();

    public void joinUser(String userId) {
        if (gameUserMOList.size() > this.gameManager.getMaxUserCount()) {
            throw new RoomException(RoomEnumeration.ROOM_NOT_FOUND);
        }

        GameUserMO gameUserMO = new GameUserMO();
        gameUserMO.setUserId(userId);
        gameUserMO.setPrepared(Boolean.TRUE);
        gameUserMOList.add(gameUserMO);
    }

    public void leaveUser(String userId) {
        Iterator<GameUserMO> iterator = gameUserMOList.iterator();
        while (iterator.hasNext()) {
            GameUserMO next = iterator.next();
            if (userId.equals(next.getUserId())) {
                iterator.remove();
                break;
            }
        }
    }

    public List<String> getAllUserList() {
        List<String> userIdList = new LinkedList<>();
        for (GameUserMO gameUserMO : this.getGameUserMOList()) {
            userIdList.add(gameUserMO.getUserId());
        }
        return userIdList;
    }

    public List<String> getAllOtherUserList(String userId) {
        List<String> userIdList = new LinkedList<>();
        for (GameUserMO gameUserMO : this.getGameUserMOList()) {
            if (!userId.equals(gameUserMO.getUserId())) {
                userIdList.add(gameUserMO.getUserId());
            }
        }
        return userIdList;
    }

    public void changeUserPrepareStatus(String userId, boolean prepared) {
        Iterator<GameUserMO> iterator = gameUserMOList.iterator();
        while (iterator.hasNext()) {
            GameUserMO next = iterator.next();
            if (userId.equals(next.getUserId())) {
                next.setPrepared(prepared);
                break;
            }
        }
    }

    public boolean empty() {
        return null == gameUserMOList ? Boolean.TRUE : CollectionUtils.isEmpty(gameUserMOList);
    }

    public boolean shouldNotStartGame() {
        return gameManager.shouldNotStartGame(this.gameUserMOList);
    }

    public void startGame() {
        this.gameManager.startGame(this.gameUserMOList);
    }

    public String chooseOneUserToRobLandlord() {
        int random  = (int) (Math.random() * this.gameUserMOList.size());
        String userId = this.getGameUserMOList().get(random).getUserId();
        this.gameManager.setRobLandlordMO(new RobLandlordMO(random, userId, 1));
        return userId;
    }

    public void thisGuyTurnToRob(String userId) {
        this.gameManager.thisGuyTurnToRob(userId);
    }

    public void thisGuyTurnToNotRob(String userId) {
        this.gameManager.thisGuyTurnToNotRob(userId);
    }

    public List<CardEnumeration> getLandlordCardList() {
        return this.gameManager.getLandlordCardList();
    }

    public void giveLandlordCardToThisGuy(String userId) {
        this.gameManager.giveLandlordCardToThisGuy(userId, this.gameUserMOList);
    }

    public boolean hasNextOneToStartRob() {
        return this.gameManager.hasNextOneToStartRob();
    }

    public String getNextOneToStartRob() {
        RobLandlordMO robLandlordMO = this.getGameManager().getRobLandlordMO();

        int index = robLandlordMO.getIndex();
        index = (index + 1) % this.gameManager.getMaxUserCount();

        int count = robLandlordMO.getCount();
        count += 1;

        String userId = this.gameUserMOList.get(index).getUserId();

        this.gameManager.setRobLandlordMO(new RobLandlordMO(index, userId, count));
        return userId;
    }

    public String getLastUser() {
        RobLandlordMO robLandlordMO = this.getGameManager().getRobLandlordMO();

        int index = robLandlordMO.getIndex();
        index = (index + 1) % this.gameManager.getMaxUserCount();

        return this.gameUserMOList.get(index).getUserId();
    }

}
