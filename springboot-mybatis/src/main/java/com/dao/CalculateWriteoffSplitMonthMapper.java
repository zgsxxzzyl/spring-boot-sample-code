package com.dao;

import com.entity.CalculateWriteoffSplitMonth;

public interface CalculateWriteoffSplitMonthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalculateWriteoffSplitMonth record);

    int insertSelective(CalculateWriteoffSplitMonth record);

    CalculateWriteoffSplitMonth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalculateWriteoffSplitMonth record);

    int updateByPrimaryKey(CalculateWriteoffSplitMonth record);
}