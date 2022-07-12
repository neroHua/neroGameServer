package com.nero.hua.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsUpdateByIdRequest {

    private Long id;

    private String title;

    private String cover;

    private String body;

}
