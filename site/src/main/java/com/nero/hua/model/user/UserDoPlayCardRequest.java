package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserDoPlayCardRequest {

    @NotNull(message = "卡牌不允许为空")
    @NotEmpty(message = "卡牌不允许为空")
    private List<CardEnumeration> cardEnumerationList;

}
