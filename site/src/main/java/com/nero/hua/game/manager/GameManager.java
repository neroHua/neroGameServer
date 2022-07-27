package com.nero.hua.game.manager;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.RobLandlordEnumeration;
import com.nero.hua.exception.RobLandlordException;
import com.nero.hua.model.user.RobLandlordMO;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class GameManager {

    private static final int COLOR_CARD_COUNT = 52;

    private static final int NORMAL_USER_CARD_COUNT = 17;

    private static final int USER_COUNT = 3;

    @Setter
    @Getter
    private RobLandlordMO robLandlordMO;

    public List<CardEnumeration> shuffleCard() {
        List<CardEnumeration> aDeckCardList = getADeckCardList();
        List<CardEnumeration> aShuffledCardList = new LinkedList<>();
        while (!aDeckCardList.isEmpty()) {
            int random = (int) (Math.random() * aDeckCardList.size());
            CardEnumeration randomCard = aDeckCardList.remove(random);
            aShuffledCardList.add(randomCard);
        }
        return aShuffledCardList;
    }

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

    public List<List<CardEnumeration>> dealCard(List<CardEnumeration> shuffledCardList) {
        List<List<CardEnumeration>> dealCardList = new LinkedList<>();

        for (int i = 0; i < USER_COUNT; i++) {
            List<CardEnumeration> userCardList = new LinkedList<>();
            for (int j = 0; j < NORMAL_USER_CARD_COUNT; j++) {
                userCardList.add(shuffledCardList.remove(0));
            }
            dealCardList.add(userCardList);
        }

        dealCardList.add(shuffledCardList);

//        sortEachCardList(dealCardList);

        return dealCardList;
    }

    public void sortEachCardList(List<List<CardEnumeration>> dealCardList) {
        for (int i = 0; i < dealCardList.size(); i++) {
            sortOneCardList(0, dealCardList.get(i).size() - 1, dealCardList.get(i));
        }
    }

    public void sortOneCardList(int start, int end, List<CardEnumeration> cardList) {
        if (start >= end) {
            return;
        }

        CardEnumeration keyCard = cardList.get(start);
        int i = start;
        int j = end;
        while (i != j) {
            if (cardList.get(i).getValue() < keyCard.getValue()) {
                CardEnumeration temp = cardList.get(j);
                cardList.set(j, cardList.get(i));
                cardList.set(i, temp);
                j--;
            }
            else {
               i++;
            }
        }

        int middle = cardList.get(i).getValue() >= keyCard.getValue() ? i : i - 1;
        if (middle >= start && middle <= end) {
            CardEnumeration temp = cardList.get(middle);
            cardList.set(middle, cardList.get(start));
            cardList.set(start, temp);
        }
        sortOneCardList(start, middle - 1, cardList);
        sortOneCardList(middle + 1, end, cardList);
    }

    public void thisGuyTurnToRob(String userId) {
        if (!this.robLandlordMO.getUserId().equals(userId)) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_YOUR_TURN_TO_ROB);
        }
    }

    public void thisGuyTurnToNotRob(String userId) {
        if (!this.robLandlordMO.getUserId().equals(userId)) {
            throw new RobLandlordException(RobLandlordEnumeration.NOT_YOUR_TURN_TO_NOT_ROB);
        }
    }

    public boolean hasNextOneToStartRob() {
        return this.robLandlordMO.getCount() >= USER_COUNT - 1;
    }
}
