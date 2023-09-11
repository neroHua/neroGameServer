package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.enumeration.RobLandlordEnumeration;
import com.nero.hua.exception.PlayCardException;
import com.nero.hua.exception.RobLandlordException;
import com.nero.hua.game.card.type.GamePlayCardType;
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
public abstract class AbstractGameManager implements GameManager {

    private List<CardEnumeration> landlordCardList;

    private RobLandlordRoundMO robLandlordRoundMO;

    private PlayCardRoundMO playCardRoundMO;

    private final GamePlayCardType gamePlayCardType;

    public AbstractGameManager(GamePlayCardType gamePlayCardType) {
        this.gamePlayCardType = gamePlayCardType;
    }

    @Override
    public boolean shouldStartGame(List<GameUserMO> gameUserMOList) {
        if (gameUserMOList.size() < this.getMaxUserCount()) {
            return Boolean.FALSE;
        }

        for (GameUserMO gameUserMO : gameUserMOList) {
            if (!gameUserMO.isPrepared()) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    @Override
    public boolean shouldNotStartGame(List<GameUserMO> gameUserMOList) {
        return !this.shouldStartGame(gameUserMOList);
    }

    @Override
    public void startGame(List<GameUserMO> gameUserMOList) {
        List<CardEnumeration> shuffledCardList = this.shuffleCard();
        List<List<CardEnumeration>> dealCardList = this.dealCard(shuffledCardList);
        for (int i = 0; i < gameUserMOList.size(); i++) {
            Map<CardEnumeration, Integer> cardMap = CardUtil.convertCardListToCardMap(dealCardList.remove(0));
            gameUserMOList.get(i).setCardMap(cardMap);
        }

        this.landlordCardList = dealCardList.get(dealCardList.size() - 1);
    }

    @Override
    public List<CardEnumeration> getAllCard() {
        List<CardEnumeration> aDeckCardList = this.getADeckCardList();
        for (int i = 2; i <= this.getDeckCardCount(); i++ ) {
            for (int j = 0; j < aDeckCardList.size(); j++) {
                aDeckCardList.add(aDeckCardList.get(j));
            }
        }
        return aDeckCardList;
    }

    @Override
    public List<CardEnumeration> shuffleCard() {
        List<CardEnumeration> allCard = this.getAllCard();
        List<CardEnumeration> shuffledCardList = new LinkedList<>();
        while (!allCard.isEmpty()) {
            int random = (int) (Math.random() * allCard.size());
            CardEnumeration randomCard = allCard.remove(random);
            shuffledCardList.add(randomCard);
        }
        return shuffledCardList;
    }

    @Override
    public List<CardEnumeration> getADeckCardList() {
        List<CardEnumeration> cardEnumerationList = new LinkedList<>();
        CardEnumeration[] cardEnumerationArray = CardEnumeration.values();
        for (int i = 0; i < COLOR_CARD_COUNT; i++) {
            cardEnumerationList.add(cardEnumerationArray[i]);
        }
        cardEnumerationList.add(CardEnumeration.CARD_516);
        cardEnumerationList.add(CardEnumeration.CARD_517);

        return cardEnumerationList;
    }

    @Override
    public List<List<CardEnumeration>> dealCard(List<CardEnumeration> shuffledCardList) {
        List<List<CardEnumeration>> dealCardList = new LinkedList<>();

        for (int i = 0; i < this.getMaxUserCount(); i++) {
            List<CardEnumeration> userCardList = new LinkedList<>();
            for (int j = 0; j < this.getNormalUserCardCount(); j++) {
                userCardList.add(shuffledCardList.remove(0));
            }
            dealCardList.add(userCardList);
        }

        dealCardList.add(shuffledCardList);

        return dealCardList;
    }

    @Override
    public String chooseOneUserToRobLandlord(List<GameUserMO> gameUserMOList) {
        int random  = (int) (Math.random() * this.getMaxUserCount());
        String userId = gameUserMOList.get(random).getUserId();
        this.robLandlordRoundMO = new RobLandlordRoundMO(random, userId);
        return userId;
    }

    @Override
    public void doRob(String userId) {
        UserRobLandlordTurnMO userRobLandlordTurnMO = this.thisGuyTurnForRobRound(userId);
        userRobLandlordTurnMO.setDoRob(Boolean.TRUE);
    }

    @Override
    public void doNotRob(String userId) {
        UserRobLandlordTurnMO userRobLandlordTurnMO = this.thisGuyTurnForRobRound(userId);
        userRobLandlordTurnMO.setDoRob(Boolean.FALSE);
    }

    @Override
    public UserRobLandlordTurnMO thisGuyTurnForRobRound(String userId) {
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

    @Override
    public int getUserIndexInUserListByUserId(String userId, List<GameUserMO> gameUserMOList) {
        for (int i = 0; i < gameUserMOList.size(); i++) {
            if (userId.equals(gameUserMOList.get(i).getUserId())) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public GameUserMO getUserInUserListByUserId(String userId, List<GameUserMO> gameUserMOList) {
        for (int i = 0; i < gameUserMOList.size(); i++) {
            if (userId.equals(gameUserMOList.get(i).getUserId())) {
                return gameUserMOList.get(i);
            }
        }
        return null;
    }

    @Override
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

    @Override
    public boolean hasNextOneToStartRob() {
        if (null == this.robLandlordRoundMO) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_TIME_TO_ROB);
        }

        return this.robLandlordRoundMO.getUserRobLandlordTurnMOList().size() < this.getMaxUserCount() - 1;
    }

    @Override
    public String makeNextUserToStartRob(List<GameUserMO> gameUserMOList) {
        int index = robLandlordRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.robLandlordRoundMO.addNewUserToStartRob(nextIndex, nextUserId);

        return nextUserId;
    }

    @Override
    public String makeLastUserRobLandlordCard(List<GameUserMO> gameUserMOList) {
        int index = robLandlordRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.robLandlordRoundMO.addNewUserToDoRob(nextIndex, nextUserId);

        return nextUserId;
    }

    @Override
    public void doPlayCard(String userId, List<CardEnumeration> cardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, List<GameUserMO> gameUserMOList) {
        if (this.gamePlayCardType.thisPlayCardTypeNotAvailable(playCardTypeEnumeration)) {
            throw new PlayCardException(PlayCardEnumeration.PLAY_CARD_TYPE_NOT_AVAILABLE);
        }

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

    @Override
    public UserPlayCardTurnMO thisGuyTurnForPlayCardRound(String userId) {
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

    @Override
    public void removeUserCardList(GameUserMO gameUserMO, List<CardEnumeration> cardEnumerationList) {
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

    @Override
    public boolean thisGuyWin(String userId, List<GameUserMO> gameUserMOList) {
        GameUserMO gameUserMO = this.getUserInUserListByUserId(userId, gameUserMOList);

        return CollectionUtils.isEmpty(gameUserMO.getCardMap());
    }

    @Override
    public String makeNextUserToStartPlayCard(List<GameUserMO> gameUserMOList) {
        int index = playCardRoundMO.getCurrentTurnUserIndex();

        int nextIndex = (index + 1) % this.getMaxUserCount();
        String nextUserId = gameUserMOList.get(nextIndex).getUserId();

        this.playCardRoundMO.addNewUserToStartPlayCard(nextIndex, nextUserId);

        return nextUserId;
    }

    @Override
    public void doNotPlayCard(String userId) {
        this.thisGuyTurnForPlayCardRound(userId);

        UserPlayCardTurnMO lastUserPlayCardTurnMO = this.playCardRoundMO.getLastUserPlayCardTurnMO();
        if (null == lastUserPlayCardTurnMO) {
            throw new PlayCardException(PlayCardEnumeration.MUST_PLAY_CARD_WHEN_ROUND_START);
        }
    }

    @Override
    public boolean hasNextOneToStartPlayCard() {
        return !this.playCardRoundMO.thisRoundFinish(this.getMaxUserCount());
    }

    @Override
    public String makeLastPlayCardUserToStartPlayCard() {
        List<UserPlayCardTurnMO> userPlayCardTurnMOList = playCardRoundMO.getUserPlayCardTurnMOList();
        UserPlayCardTurnMO lastUserPlayCardTurnMO = userPlayCardTurnMOList.get(userPlayCardTurnMOList.size() - 1 - (this.getMaxUserCount() - 1));

        this.playCardRoundMO = new PlayCardRoundMO();
        this.playCardRoundMO.addNewUserToStartPlayCard(lastUserPlayCardTurnMO.getUserIndex(), lastUserPlayCardTurnMO.getUserId());

        return lastUserPlayCardTurnMO.getUserId();
    }
}
