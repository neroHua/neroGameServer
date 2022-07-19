package com.nero.hua.exception;

import com.nero.hua.enumeration.RoomEnumeration;

public class RoomException extends BusinessException {

    public RoomException(RoomEnumeration roomEnumeration) {
        super(roomEnumeration.getCode(), roomEnumeration.getMessage());
    }

    public RoomException(String message, String code) {
        super(message, code);
    }

    public RoomException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
