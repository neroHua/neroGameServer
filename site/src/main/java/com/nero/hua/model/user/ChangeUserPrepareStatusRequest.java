package com.nero.hua.model.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChangeUserPrepareStatusRequest {

    @NotNull(message = "准备状态不能未空")
    private Boolean prepared;
}
