package com.nero.hua.model.room;

import com.nero.hua.enumeration.GameTypeEnumeration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateRoomRequest {

    @NotNull(message = "游戏类型不能为空")
    GameTypeEnumeration gameTypeEnumeration;

}
