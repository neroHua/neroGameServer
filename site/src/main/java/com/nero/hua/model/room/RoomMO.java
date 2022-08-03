package com.nero.hua.model.room;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.user.GameUserMO;
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
        return this.gameManager.chooseOneUserToRobLandlord(this.gameUserMOList);
    }

    public void doRob(String userId) {
        this.gameManager.doRob(userId);
    }

    public void doNotRob(String userId) {
        this.gameManager.doNotRob(userId);
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

    public String makeNextUserToStartRob() {
        return this.gameManager.makeNextUserToStartRob(this.gameUserMOList);
    }

    public String makeLastUserRobLandlordCard() {
        return this.gameManager.makeLastUserRobLandlordCard(this.gameUserMOList);
    }

    public void doPlayCard(String userId, List<CardEnumeration> cardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration) {
        this.gameManager.doPlayCard(userId, cardEnumerationList, playCardTypeEnumeration, this.gameUserMOList);
    }

    public boolean thisGuyWin(String userId) {
        return this.gameManager.thisGuyWin(userId, this.gameUserMOList);
    }

    public String makeNextUserToStartPlayCard() {
        return this.gameManager.makeNextUserToStartPlayCard(this.gameUserMOList);
    }

    public void doNotPlayCard(String userId) {
        this.gameManager.doNotPlayCard(userId);
    }

    public boolean hasNextOneToStartPlayCard() {
        return this.gameManager.hasNextOneToStartPlayCard();
    }

    public String makeLastPlayCardUserToStartPlayCard() {
        return this.gameManager.makeLastPlayCardUserToStartPlayCard();
    }
}
