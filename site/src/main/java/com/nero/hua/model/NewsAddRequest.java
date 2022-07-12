package com.nero.hua.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NewsAddRequest {

    @NotNull(message = "标题不能为空")
    @NotBlank(message = "标题不能为空")
    @Length(max = 64, message = "标题字长不能超过64")
    private String title;

    private String cover;

    private String body;

}
