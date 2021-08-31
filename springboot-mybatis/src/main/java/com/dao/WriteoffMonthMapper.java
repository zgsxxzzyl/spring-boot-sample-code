package com.dao;

import com.entity.WriteoffMonth;

public interface WriteoffMonthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WriteoffMonth record);

    int insertSelective(WriteoffMonth record);

    WriteoffMonth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WriteoffMonth record);

    int updateByPrimaryKey(WriteoffMonth record);
}