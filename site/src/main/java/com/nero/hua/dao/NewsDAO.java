package com.nero.hua.dao;

import com.nero.hua.bean.NewsDO;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDAO {

    Long insert(NewsDO newsDO);

    Integer deleteById(Long id);

    Integer updateById(@Param("newsDO") NewsDO newsDO);

    NewsDO selectById(Long id);

    List<NewsDO> selectListByPage(@Param("keyword") String keyword, @Param("begin") Long begin, @Param("pageSize") Integer pageSize);

    Long selectCountByPage(@Param("keyword") String keyword);

}
