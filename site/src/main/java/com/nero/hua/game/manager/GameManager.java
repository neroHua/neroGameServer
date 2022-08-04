package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.enumeration.RobLandlordEnumeration;
import com.nero.hua.exception.PlayCardException;
import com.nero.hua.exception.RobLandlordException;
import com.nero.hua.model.user.*;
import com.nero.hua.util.CardUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GameManager {

    private static final int COLOR_CARD_COUNT = 52;

    private static final int NORMAL_USER_CARD_COUNT = 17;

    private static final int LANDLORD_CARD_COUNT = 3;

    private static final int MAX_USER_COUNT = 3;

    private List<CardEnumeration> landlordCardList;

    private RobLandlordRoundMO robLandlordRoundMO;

    private PlayCardRoundMO playCardRoundMO;

    public int getMaxUserCount() {
        return MAX_USER_COUNT;
    }

    public int getNormalUserCardCount() {
        return NORMAL_USER_CARD_COUNT;
    }

    public int getLandlordCardCount() {
        return LANDLORD_CARD_COUNT;
    }

    public boolean shouldStartGame(List<GameUserMO> gameUserMOList) {
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

    public boolean shouldNotStartGame(List<GameUserMO> gameUserMOList) {
        return !this.shouldStartGame(gameUserMOList);
    }

    public void startGame(List<GameUserMO> gameUserMOList) {
        List<CardEnumeration> shuffledCardList = this.shuffleCard();
        List<List<CardEnumeration>> dealCardList = this.dealCard(shuffledCardList);
        for (int i = 0; i < gameUserMOList.size(); i++) {
            Map<CardEnumeration, Integer> cardMap = CardUtil.convertCardListToCardMap(dealCardList.remove(0));
            gameUserMOList.get(i).setCardMap(cardMap);
        }

        this.landlordCardList = dealCardList.get(dealCardList.size() - 1);
    }

    private List<CardEnumeration> shuffleCard() {
        List<CardEnumeration> aDeckCardList = getADeckCardList();
        List<CardEnumeration> aShuffledCardList = new LinkedList<>();
        while (!aDeckCardList.isEmpty()) {
            int random = (int) (Math.random() * aDeckCardList.size());
            CardEnumeration randomCard = aDeckCardList.remove(random);
            aShuffledCardList.add(randomCard);
        }
        return aShuffledCardList;
    }

    private List<CardEnumeration> getADeckCardList() {
        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        CardEnumeration[] cardEnumerationArray = CardEnumeration.values();
        for (int i = 0; i < COLOR_CARD_COUNT; i++) {
            cardEnumerationList.add(cardEnumerationArray[i]);
        }
        cardEnumerationList.add(CardEnumeration.CARD_516);
        cardEnumerationList.add(CardEnumeration.CARD_517);

        return cardEnumerationList;
    }

    private List<List<CardEnumeration>> dealCard(List<CardEnumeration> shuffledCardList) {
        List<List<CardEnumeration>> dealCardList = new LinkedList<>();

        for (int i = 0; i < MAX_USER_COUNT; i++) {
            List<CardEnumeration> userCardList = new LinkedList<>();
            for (int j = 0; j < NORMAL_USER_CARD_COUNT; j++) {
                userCardList.add(shuffledCardList.remove(0));
            }
            dealCardList.add(userCardList);
        }

        dealCardList.add(shuffledCardList);

        return dealCardList;
    }

    public String chooseOneUserToRobLandlord(List<GameUserMO> gameUserMOList) {
        int random  = (int) (Math.random() * MAX_USER_COUNT);
        String userId = gameUserMOList.get(random).getUserId();
        this.robLandlordRoundMO = new RobLandlordRoundMO(random, userId);
        return userId;
    }

    public void doRob(String userId) {
        UserRobLandlordTurnMO userRobLandlordTurnMO = this.thisGuyTurnForRobRound(userId);
        userRobLandlordTurnMO.setDoRob(Boolean.TRUE);
    }

    public void doNotRob(String userId) {
        UserRobLandlordTurnMO userRobLandlordTurnMO = this.thisGuyTurnForRobRound(userId);
        userRobLandlordTurnMO.setDoRob(Boolean.FALSE);
    }

    private UserRobLandlordTurnMO thisGuyTurnForRobRound(String userId) {
        if (null == this.robLandlordRoundMO) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_TIME_TO_ROB);
        }

        List<UserRobLandlordTurnMO> userRobLandlordTurnMOList = this.robLandlordRoundMO.getUserRobLandlordTurnMOList();
        UserRobLandlordTurnMO userRobLandlordTurnMO = userRobLandlordTurnMOList.get(userRobLandlordTurnMOList.size() - 1);
        if (!userId.equals(userRobLandlordTurnMO.getUserId())) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_YOUR_TURN);
        }

        return userRobLandlordTurnMO;
    }

    private int getUserIndexInUserListByUserId(String userId, List<GameUserMO> gameUserMOList) {
        for (int i = 0; i < gameUserMOList.size(); i++) {
            if (userId.equals(gameUserMOList.get(i).getUserId())) {
                return i;
            }
        }
        return 0;
    }

    private GameUserMO getUserInUserListByUserId(String userId, List<GameUserMO> gameUserMOList) {
        for (int i = 0; i < gameUserMOList.size(); i++) {
            if (userId.equals(gameUserMOList.get(i).getUserId())) {
                return gameUserMOList.get(i);
            }
        }
        return null;
    }

    public void giveLandlordCardToThisGuy(String userId, List<GameUserMO> gameUserMOList) {
        int userIndex = this.getUserIndexInUserListByUserId(userId, gameUserMOList);

        GameUserMO gameUserMO = gameUserMOList.get(userIndex);

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

        this.playCardRoundMO = new PlayCardRoundMO();
        this.playCardRoundMO.addNewUserToStartPlayCard(userIndex, userId);
    }

    public boolean hasNextOneToStartRob() {
        if (null == this.robLandlordRoundMO) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_TIME_TO_ROB);
        }

        return this.robLandlordRoundMO.getUserRobLandlordTurnMOList().size() < MAX_USER_COUNT - 1;
    }

    public String makeNextUserToStartRob(List<GameUserMO> gameUserMOList) {
        int index = robLandlordRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.robLandlordRoundMO.addNewUserToStartRob(nextIndex, nextUserId);

        return nextUserId;
    }

    public String makeLastUserRobLandlordCard(List<GameUserMO> gameUserMOList) {
        int index = robLandlordRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.robLandlordRoundMO.addNewUserToDoRob(nextIndex, nextUserId);

        return nextUserId;
    }

    public void doPlayCard(String userId, List<CardEnumeration> cardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, List<GameUserMO> gameUserMOList) {
        if (CardUtil.playCardNotMatchPlayCardType(cardEnumerationList, playCardTypeEnumeration)) {
            throw new PlayCardException(PlayCardEnumeration.PLAY_CARD_DO_NOT_MATCH_ITS_TYPE);
        }

        UserPlayCardTurnMO userPlayCardTurnMO = this.thisGuyTurnForPlayCardRound(userId);

        GameUserMO gameUserMO = gameUserMOList.get(userPlayCardTurnMO.getUserIndex());
        Map<CardEnumeration, Integer> cardEnumerationMap = CardUtil.convertCardListToCardMap(cardEnumerationList);
        if (CardUtil.handCardMapNotContainsPlayCardMap(gameUserMO.getCardMap(), cardEnumerationMap)) {
            throw new PlayCardException(PlayCardEnumeration.HAND_CARD_DO_NOT_CONTAINS_PLAY_CARD);
        }

        UserPlayCardTurnMO lastUserPlayCardTurnMO = this.playCardRoundMO.getLastUserPlayCardTurnMO();
        if (CardUtil.currentPlayCardListNotBetterThanLastPlayCardList(lastUserPlayCardTurnMO, cardEnumerationList, playCardTypeEnumeration)) {
           throw new PlayCardException(PlayCardEnumeration.PLAY_CARD_DO_NOT_BETTER_THAN_LAST_PLAY_CARD);
        }

        this.removeUserCardList(gameUserMO, cardEnumerationList);

        userPlayCardTurnMO.setCardList(cardEnumerationList);
        userPlayCardTurnMO.setPlayCardTypeEnumeration(playCardTypeEnumeration);
    }

    private UserPlayCardTurnMO thisGuyTurnForPlayCardRound(String userId) {
        if (null == this.playCardRoundMO) {
            throw new PlayCardException(PlayCardEnumeration.NOT_TIME_TO_PLAY_CARD);
        }

        List<UserPlayCardTurnMO> userPlayCardTurnMOList = this.playCardRoundMO.getUserPlayCardTurnMOList();
        UserPlayCardTurnMO userPlayCardTurnMO = userPlayCardTurnMOList.get(userPlayCardTurnMOList.size() - 1);
        if (!userId.equals(userPlayCardTurnMO.getUserId())) {
            throw new PlayCardException(PlayCardEnumeration.NOT_YOUR_TURN);
        }

        return userPlayCardTurnMO;
    }

    private void removeUserCardList(GameUserMO gameUserMO, List<CardEnumeration> cardEnumerationList) {
        Map<CardEnumeration, Integer> cardMap = gameUserMO.getCardMap();
        for (CardEnumeration cardEnumeration : cardEnumerationList) {
            Integer cardCount = cardMap.get(cardEnumeration);
            if (1 == cardCount) {
                cardMap.remove(cardEnumeration);
            }
            else {
                cardMap.put(cardEnumeration, cardCount - 1);
            }
        }
    }

    public boolean thisGuyWin(String userId, List<GameUserMO> gameUserMOList) {
        GameUserMO gameUserMO = this.getUserInUserListByUserId(userId, gameUserMOList);

        return CollectionUtils.isEmpty(gameUserMO.getCardMap());
    }

    public String makeNextUserToStartPlayCard(List<GameUserMO> gameUserMOList) {
        int index = playCardRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.playCardRoundMO.addNewUserToStartPlayCard(nextIndex, nextUserId);

        return nextUserId;
    }

    public void doNotPlayCard(String userId) {
        this.thisGuyTurnForPlayCardRound(userId);
    }

    public boolean hasNextOneToStartPlayCard() {
        return !this.playCardRoundMO.thisRoundFinish(this.getMaxUserCount());
    }

    public String makeLastPlayCardUserToStartPlayCard() {
        int index = playCardRoundMO.getCurrentTurnUserIndex();

        List<UserPlayCardTurnMO> userPlayCardTurnMOList = playCardRoundMO.getUserPlayCardTurnMOList();

        String userId = userPlayCardTurnMOList.get(userPlayCardTurnMOList.size() - 1 - (MAX_USER_COUNT - 1)).getUserId();

        this.playCardRoundMO = new PlayCardRoundMO();
        this.playCardRoundMO.addNewUserToStartPlayCard(index, userId);

        return userId;
    }
}
