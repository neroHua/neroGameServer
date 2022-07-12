package com.nero.hua.service.impl;

import com.nero.hua.bean.NewsDO;
import com.nero.hua.bean.NewsDetailDO;
import com.nero.hua.convert.NewsConvert;
import com.nero.hua.dao.NewsDAO;
import com.nero.hua.dao.NewsDetailDAO;
import com.nero.hua.model.*;
import com.nero.hua.model.base.BasePageResponse;
import com.nero.hua.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Autowired
    private NewsDetailDAO newsDetailDAO;

    @Override
    @Transactional
    public Long addNews(NewsAddRequest newsAddRequest, Long userId) {
        NewsDetailDO newsDetailDO = NewsConvert.convertRequestToDO(newsAddRequest, userId);
        newsDetailDAO.insert(newsDetailDO);

        NewsDO newsDO = NewsConvert.convertRequestToDO(newsAddRequest, newsDetailDO.getId(), userId);
        newsDAO.insert(newsDO);

        return newsDO.getId();
    }

    @Override
    @Transactional
    public Integer updateNewsById(NewsUpdateByIdRequest newsUpdateByIdRequest, Long userId) {
        if (null != newsUpdateByIdRequest.getBody()) {
            NewsDO newsDO = newsDAO.selectById(newsUpdateByIdRequest.getId());
            NewsDetailDO newsDetailDO = NewsConvert.convertRequestToDOForDetail(newsUpdateByIdRequest, newsDO, userId);
            newsDetailDAO.updateById(newsDetailDO);
        }

        NewsDO newsDO = NewsConvert.convertRequestToDO(newsUpdateByIdRequest, userId);
        Integer updateCount = newsDAO.updateById(newsDO);

        return updateCount;
    }

    @Override
    public BasePageResponse<NewsResponse> selectNewsByPage(NewsPageRequest newsPageRequest) {
        Long totalCount = newsDAO.selectCountByPage(newsPageRequest.getKeyword());
        List<NewsDO> newsDOList = newsDAO.selectListByPage(newsPageRequest.getKeyword(), newsPageRequest.calculateBegin(), newsPageRequest.getPageSize());

        List<NewsResponse> newsResponseList = NewsConvert.convertDOToResponse(newsDOList);

        return new BasePageResponse<>(totalCount, newsResponseList);
    }

    @Override
    public NewsDetailResponse selectNewsDetailById(Long id) {
        NewsDetailDO newsDetailDO = newsDetailDAO.selectById(id);
        return NewsConvert.convertDOToResponse(newsDetailDO);
    }

}
