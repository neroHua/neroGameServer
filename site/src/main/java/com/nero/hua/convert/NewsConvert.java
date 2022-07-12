package com.nero.hua.convert;

import com.nero.hua.bean.NewsDO;
import com.nero.hua.bean.NewsDetailDO;
import com.nero.hua.model.NewsAddRequest;
import com.nero.hua.model.NewsDetailResponse;
import com.nero.hua.model.NewsResponse;
import com.nero.hua.model.NewsUpdateByIdRequest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsConvert {

    public static NewsDO convertRequestToDO(NewsAddRequest request, Long newsDetailId, Long userId) {
        NewsDO do1 = new NewsDO();

        do1.setCreateTime(new Date());
        do1.setUpdateTime(new Date());
        do1.setCreateUserId(userId);
        do1.setUpdateUserId(userId);

        do1.setTitle(request.getTitle());
        do1.setCover(request.getCover());
        do1.setDetailId(newsDetailId);

        return do1;
    }

    public static NewsDetailDO convertRequestToDO(NewsAddRequest request, Long userId) {
        NewsDetailDO do1 = new NewsDetailDO();

        do1.setCreateTime(new Date());
        do1.setUpdateTime(new Date());
        do1.setCreateUserId(userId);
        do1.setUpdateUserId(userId);

        do1.setDetail(request.getBody());

        return do1;
    }

    public static NewsDO convertRequestToDO(NewsUpdateByIdRequest request, Long userId) {
        NewsDO do1 = new NewsDO();

        do1.setUpdateTime(new Date());
        do1.setUpdateUserId(userId);

        do1.setId(request.getId());
        do1.setTitle(request.getTitle());
        do1.setCover(request.getCover());

        return do1;
    }

    public static NewsDetailDO convertRequestToDOForDetail(NewsUpdateByIdRequest request, NewsDO newsDO, Long userId) {
        NewsDetailDO do1 = new NewsDetailDO();

        do1.setUpdateTime(new Date());
        do1.setUpdateUserId(userId);

        do1.setId(newsDO.getDetailId());
        do1.setDetail(request.getBody());

        return do1;
    }

    public static NewsResponse convertDOToResponse(NewsDO do1) {
        NewsResponse response = new NewsResponse();

        response.setCreateTime(do1.getCreateTime());
        response.setUpdateTime(do1.getUpdateTime());
        response.setCreateUserId(do1.getCreateUserId());
        response.setUpdateUserId(do1.getUpdateUserId());

        response.setId(do1.getId());
        response.setTitle(do1.getTitle());
        response.setCover(do1.getCover());
        response.setDetailId(do1.getDetailId());

        return response;
    }

    public static List<NewsResponse> convertDOToResponse(List<NewsDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
            return null;
        }

        List<NewsResponse> responseList = new ArrayList<>(doList.size());
        for (int i = 0; i < doList.size(); i++) {
            responseList.add(i, convertDOToResponse(doList.get(i)));
        }

        return responseList;
    }

    public static NewsDetailResponse convertDOToResponse(NewsDetailDO do1) {
        NewsDetailResponse response = new NewsDetailResponse();

        response.setCreateTime(do1.getCreateTime());
        response.setUpdateTime(do1.getUpdateTime());
        response.setCreateUserId(do1.getCreateUserId());
        response.setUpdateUserId(do1.getUpdateUserId());

        response.setId(do1.getId());
        response.setDetail(do1.getDetail());

        return response;
    }
}
