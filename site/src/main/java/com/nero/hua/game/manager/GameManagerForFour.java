package com.nero.hua.game.manager;

import com.nero.hua.game.card.type.GamePlayCardTypeForFour;

public class GameManagerForFour extends AbstractGameManager {

    private static final int NORMAL_USER_CARD_COUNT = 25;

    private static final int LANDLORD_CARD_COUNT = 8;

    private static final int MAX_USER_COUNT = 4;

    private static final int DECK_CARD_COUNT = 2;

    public GameManagerForFour() {
        super(new GamePlayCardTypeForFour());
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
