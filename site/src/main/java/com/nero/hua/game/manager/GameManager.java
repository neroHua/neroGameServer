package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import com.nero.hua.model.user.GameUserMO;
import com.nero.hua.model.user.UserPlayCardTurnMO;
import com.nero.hua.model.user.UserRobLandlordTurnMO;

import java.util.List;
import java.util.Set;

public interface GameManager {

    int COLOR_CARD_COUNT = 52;

    int getMaxUserCount();

    int getNormalUserCardCount();

    int getLandlordCardCount();

    Set<PlayCardTypeEnumeration> getAllAvailableCardType();

    boolean shouldStartGame(List<GameUserMO> gameUserMOList);

    boolean shouldNotStartGame(List<GameUserMO> gameUserMOList);

    void startGame(List<GameUserMO> gameUserMOList);

    List<CardEnumeration> getAllCard();

    List<CardEnumeration> shuffleCard();

    List<CardEnumeration> getADeckCardList();

    List<List<CardEnumeration>> dealCard(List<CardEnumeration> shuffledCardList);

    String chooseOneUserToRobLandlord(List<GameUserMO> gameUserMOList);

    void doRob(String userId);

    void doNotRob(String userId);

    UserRobLandlordTurnMO thisGuyTurnForRobRound(String userId);

    int getUserIndexInUserListByUserId(String userId, List<GameUserMO> gameUserMOList);

    GameUserMO getUserInUserListByUserId(String userId, List<GameUserMO> gameUserMOList);

    void giveLandlordCardToThisGuy(String userId, List<GameUserMO> gameUserMOList);

    boolean hasNextOneToStartRob();

    String makeNextUserToStartRob(List<GameUserMO> gameUserMOList);

    String makeLastUserRobLandlordCard(List<GameUserMO> gameUserMOList);

    void doPlayCard(String userId, List<CardEnumeration> cardEnumerationList, PlayCardTypeEnumeration playCardTypeEnumeration, List<GameUserMO> gameUserMOList);

    UserPlayCardTurnMO thisGuyTurnForPlayCardRound(String userId);

    void removeUserCardList(GameUserMO gameUserMO, List<CardEnumeration> cardEnumerationList);

    boolean thisGuyWin(String userId, List<GameUserMO> gameUserMOList);

    String makeNextUserToStartPlayCard(List<GameUserMO> gameUserMOList);

    void doNotPlayCard(String userId);

    boolean hasNextOneToStartPlayCard();

    String makeLastPlayCardUserToStartPlayCard();

}
