package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GameManagerForThree extends AbstractGameManager {

    private static final int NORMAL_USER_CARD_COUNT = 17;

    private static final int LANDLORD_CARD_COUNT = 3;

    private static final int MAX_USER_COUNT = 3;

    private static final Set<PlayCardTypeEnumeration> playCardTypeSet = new HashSet<>();

    static {
        playCardTypeSet.add(PlayCardTypeEnumeration.SINGLE);
        playCardTypeSet.add(PlayCardTypeEnumeration.STRAIGHT);

        playCardTypeSet.add(PlayCardTypeEnumeration.PAIR);
        playCardTypeSet.add(PlayCardTypeEnumeration.PAIR_STRAIGHT);

        playCardTypeSet.add(PlayCardTypeEnumeration.TRIPLE);
        playCardTypeSet.add(PlayCardTypeEnumeration.TRIPLE_SINGLE);
        playCardTypeSet.add(PlayCardTypeEnumeration.TRIPLE_PAIR);

        playCardTypeSet.add(PlayCardTypeEnumeration.AIRPLANE);
        playCardTypeSet.add(PlayCardTypeEnumeration.AIRPLANE_SINGLE);
        playCardTypeSet.add(PlayCardTypeEnumeration.AIRPLANE_PAIR);

        playCardTypeSet.add(PlayCardTypeEnumeration.FOUR_SINGLE);
        playCardTypeSet.add(PlayCardTypeEnumeration.FOUR_PAIR);

        playCardTypeSet.add(PlayCardTypeEnumeration.BOMB);
        playCardTypeSet.add(PlayCardTypeEnumeration.BOMB_KING);
    }

    @Override
    public int getMaxUserCount() {
        return MAX_USER_COUNT;
    }

    @Override
    public int getNormalUserCardCount() {
        return NORMAL_USER_CARD_COUNT;
    }

    @Override
    public int getLandlordCardCount() {
        return LANDLORD_CARD_COUNT;
    }

    @Override
    public Set<PlayCardTypeEnumeration> getAllAvailableCardType() {
        return playCardTypeSet;
    }

    @Override
    public List<CardEnumeration> getAllCard() {
        return super.getADeckCardList();
    }
}
