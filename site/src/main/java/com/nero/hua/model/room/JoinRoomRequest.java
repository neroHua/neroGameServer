package com.nero.hua.model.room;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class JoinRoomRequest {

    @Min(value = 1, message = "房间号不能小于0")
    @NotNull(message = "房间号不能为空")
    Long roomId;

}
