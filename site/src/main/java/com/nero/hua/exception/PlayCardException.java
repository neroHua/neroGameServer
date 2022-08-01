package com.nero.hua.exception;

import com.nero.hua.enumeration.PlayCardEnumeration;

public class PlayCardException extends BusinessException {

    public PlayCardException(PlayCardEnumeration playCardEnumeration) {
        super(playCardEnumeration.getCode(), playCardEnumeration.getMessage());
    }

    public PlayCardException(String message, String code) {
        super(message, code);
    }

    public PlayCardException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
