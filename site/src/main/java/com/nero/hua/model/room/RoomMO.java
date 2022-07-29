package com.nero.hua.model.room;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.RoomEnumeration;
import com.nero.hua.exception.RoomException;
import com.nero.hua.game.manager.GameManager;
import com.nero.hua.model.user.GameUserMO;
import com.nero.hua.model.user.RobLandlordMO;
import com.nero.hua.util.CardUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Setter
@Getter
public class RoomMO {

    private static int MAX_USER_COUNT = 3;

    private Long roomId;

    private GameManager gameManager;

    private List<GameUserMO> gameUserMOList = new ArrayList<>();

    private List<CardEnumeration> landlordCardList;

    public void joinUser(String userId) {
        if (gameUserMOList.size() > MAX_USER_COUNT) {
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

    public boolean shouldStartGame() {
        if (gameUserMOList.size() < MAX_USER_COUNT) {
            return Boolean.FALSE;
        }

        for (GameUserMO gameUserMO : gameUserMOList) {
            if (!gameUserMO.isPrepared()) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public boolean shouldNotStartGame() {
        return !shouldStartGame();
    }

    public boolean empty() {
        return null == gameUserMOList ? Boolean.TRUE : CollectionUtils.isEmpty(gameUserMOList);
    }

    public void startGame() {
        List<CardEnumeration> shuffledCardList = gameManager.shuffleCard();
        List<List<CardEnumeration>> dealCardList =  gameManager.dealCard(shuffledCardList);
        for (int i = 0; i < gameUserMOList.size(); i++) {
            Map<CardEnumeration, Integer> cardMap = CardUtil.convertCardListToCardMap(dealCardList.remove(0));
            gameUserMOList.get(i).setCardMap(cardMap);
        }

        this.landlordCardList = dealCardList.get(dealCardList.size() - 1);
    }

    public String chooseOneUserToRobLandlord() {
        int random  = (int) (Math.random() * this.gameUserMOList.size());
        String userId = this.getGameUserMOList().get(random).getUserId();
        this.gameManager.setRobLandlordMO(new RobLandlordMO(random, userId, 1));
        return userId;
    }

    public void thisGuyTurnToRob(String userId) {
        this.getGameManager().thisGuyTurnToRob(userId);
    }

    public void thisGuyTurnToNotRob(String userId) {
        this.getGameManager().thisGuyTurnToNotRob(userId);
    }

    public void giveLandlordCardToThisGuy(String userId) {
        GameUserMO gameUserMO = null;
        for (int i = 0; i < this.gameUserMOList.size(); i++) {
            if (userId.equals(this.gameUserMOList.get(i).getUserId())) {
                gameUserMO = this.gameUserMOList.get(i);
            }
        }

        Map<CardEnumeration, Integer> cardMap = gameUserMO.getCardMap();
        for (CardEnumeration cardEnumeration : this.landlordCardList) {
            if (cardMap.containsKey(cardEnumeration)) {
                Integer count = cardMap.get(cardEnumeration);
                cardMap.put(cardEnumeration, count + 1);
            }
            else {
                cardMap.put(cardEnumeration, 1);
            }
        }

        this.landlordCardList = null;
    }

    public boolean hasNextOneToStartRob() {
        return this.gameManager.hasNextOneToStartRob();
    }

    public String getNextOneToStartRob() {
        RobLandlordMO robLandlordMO = this.getGameManager().getRobLandlordMO();

        int index = robLandlordMO.getIndex();
        index = (index + 1) % MAX_USER_COUNT;

        int count = robLandlordMO.getCount();
        count += 1;

        String userId = this.gameUserMOList.get(index).getUserId();

        this.gameManager.setRobLandlordMO(new RobLandlordMO(index, userId, count));
        return userId;
    }

    public String getLastUser() {
        RobLandlordMO robLandlordMO = this.getGameManager().getRobLandlordMO();

        int index = robLandlordMO.getIndex();
        index = (index + 1) % MAX_USER_COUNT;

        return this.gameUserMOList.get(index).getUserId();
    }

}
