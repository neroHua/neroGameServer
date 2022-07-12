package com.nero.hua.controller;

import com.nero.hua.constant.LoginConstant;
import com.nero.hua.model.*;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.model.base.BaseResponse;
import com.nero.hua.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public BaseResponse<Long> addNews(@RequestBody @Validated NewsAddRequest newsAddRequest, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute(LoginConstant.USER_ID);

        Long newsId = newsService.addNews(newsAddRequest, userId);

        return new BaseResponse(newsId);
    }

    @PutMapping
    public BaseResponse<Integer> updateNewsById(@RequestBody @Validated NewsUpdateByIdRequest newsUpdateByIdRequest, HttpSession httpSession) {
        Long userId = (Long) httpSession.getAttribute(LoginConstant.USER_ID);

        Integer updateCount = newsService.updateNewsById(newsUpdateByIdRequest, userId);

        return new BaseResponse(updateCount);
    }

    @GetMapping(value = "/list")
    public BaseResponse<BasePageResponse<NewsResponse>> selectNewsByPage(@Validated NewsPageRequest newsPageRequest) {
        BasePageResponse<NewsResponse> newsPageResponse = newsService.selectNewsByPage(newsPageRequest);
        return new BaseResponse(newsPageResponse);
    }

    @GetMapping(value = "/detail/{id}")
    public BaseResponse<NewsResponse> selectNewsByPage(@PathVariable(name = "id") Long id) {
        NewsDetailResponse newsDetailResponse = newsService.selectNewsDetailById(id);
        return new BaseResponse(newsDetailResponse);
    }

}
