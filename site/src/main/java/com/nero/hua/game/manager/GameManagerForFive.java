package com.nero.hua.game.manager;

import com.nero.hua.game.card.type.GamePlayCardTypeForFive;

public class GameManagerForFive extends AbstractGameManager {

    private static final int NORMAL_USER_CARD_COUNT = 31;

    private static final int LANDLORD_CARD_COUNT = 7;

    private static final int MAX_USER_COUNT = 5;

    private static final int DECK_CARD_COUNT = 3;

    public GameManagerForFive() {
        super(new GamePlayCardTypeForFive());
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
    public int getDeckCardCount() {
        return DECK_CARD_COUNT;
    }

}
