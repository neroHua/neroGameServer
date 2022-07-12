package com.nero.hua.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewsResponse {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long createUserId;

    private Long updateUserId;

    private String title;

    private String cover;

    private Long detailId;
}
