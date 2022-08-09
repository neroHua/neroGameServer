package com.nero.hua.model.user;

import com.nero.hua.enumeration.CardEnumeration;
import com.nero.hua.enumeration.PlayCardTypeEnumeration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class UserDoPlayCardRequest {

    /**
     * 客户端需要根据牌型把本字段格式化并排序降低服务器计算压力
     *
     * 比如
     *  顺子：7, 6, 5, 4, 3
     *  对子：5，5, 4, 4, 3, 3
     *  三带一: 3, 3, 3, 2
     *  三带对: 3, 3, 3, 2, 2
     *  飞机带单: 4, 4, 4, 3, 3, 3, 2, 1
     *  飞机带对: 4, 4, 4, 3, 3, 3, 2, 2, 1, 1
     *  王炸：大王, 小王
     *
     */
    @NotNull(message = "卡牌不允许为空")
    @NotEmpty(message = "卡牌不允许为空")
    private List<CardEnumeration> cardEnumerationList;

    @NotNull(message = "牌型不允许为空")
    private PlayCardTypeEnumeration playCardTypeEnumeration;

}
