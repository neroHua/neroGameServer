package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GameUserMO {

    private String userId;

    private boolean prepared;

    private Map<CardEnumeration, Integer> cardMap;

    private Long score;

}
