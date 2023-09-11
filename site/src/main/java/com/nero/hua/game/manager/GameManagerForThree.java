package com.nero.hua.game.manager;

import com.nero.hua.game.card.type.GamePlayCardTypeForThree;

public class GameManagerForThree extends AbstractGameManager {

    private static final int NORMAL_USER_CARD_COUNT = 17;

    private static final int LANDLORD_CARD_COUNT = 3;

    private static final int MAX_USER_COUNT = 3;

    private static final int DECK_CARD_COUNT = 1;

    public GameManagerForThree() {
        super(new GamePlayCardTypeForThree());
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
