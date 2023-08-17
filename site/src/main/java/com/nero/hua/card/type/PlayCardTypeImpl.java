package com.nero.hua.card.type;

import com.nero.hua.enumeration.PlayCardTypeEnumeration;

public class PlayCardTypeImpl implements PlayCardType {

    protected final PlayCardTypeEnumeration playCardTypeEnumeration;

    public PlayCardTypeImpl(PlayCardTypeEnumeration playCardTypeEnumeration) {
        this.playCardTypeEnumeration = playCardTypeEnumeration;
    }

    @Override
    public PlayCardTypeEnumeration getPlayCardTypeEnumeration() {
        return this.playCardTypeEnumeration;
    }

}
