package com.nero.hua.model;

import com.nero.hua.model.base.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsPageRequest extends BasePageRequest {

    private String titleLike;

}
