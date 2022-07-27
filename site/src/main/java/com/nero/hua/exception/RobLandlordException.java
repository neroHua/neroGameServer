package com.nero.hua.exception;

import com.nero.hua.enumeration.RobLandlordEnumeration;

public class RobLandlordException extends BusinessException {

    public RobLandlordException(RobLandlordEnumeration robLandlordEnumeration) {
        super(robLandlordEnumeration.getCode(), robLandlordEnumeration.getMessage());
    }

    public RobLandlordException(String message, String code) {
        super(message, code);
    }

    public RobLandlordException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

}
