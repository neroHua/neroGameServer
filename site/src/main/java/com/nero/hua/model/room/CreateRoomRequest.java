package com.nero.hua.model.room;

import com.nero.hua.enumeration.GameTypeEnumeration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateRoomRequest {

    @Min(value = 1, message = "游戏类型不能小于0")
    @NotNull(message = "游戏类型不能为空")
    GameTypeEnumeration gameTypeEnumeration;

}
