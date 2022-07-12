package com.nero.hua.service;

import com.nero.hua.model.*;
import com.nero.hua.model.base.BasePageResponse;

import java.util.List;

public interface NewsService {

    Long addNews(NewsAddRequest newsAddRequest, Long userId);

    Integer updateNewsById(NewsUpdateByIdRequest newsUpdateByIdRequest, Long userId);

    BasePageResponse<NewsResponse> selectNewsByPage(NewsPageRequest newsPageRequest);

    NewsDetailResponse selectNewsDetailById(Long id);
}
