package com.nero.hua.dao;

import com.nero.hua.bean.NewsDetailDO;
import org.apache.ibatis.annotations.Param;

public interface NewsDetailDAO {

    Long insert(NewsDetailDO newsDetailDO);

    Integer deleteById(Long id);

    Integer updateById(@Param("newsDetailDO") NewsDetailDO newsDetailDO);

    NewsDetailDO selectById(Long id);
}
