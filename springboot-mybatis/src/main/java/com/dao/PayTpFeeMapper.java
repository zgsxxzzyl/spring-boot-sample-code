package com.dao;

import com.entity.PayTpFee;

public interface PayTpFeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayTpFee record);

    int insertSelective(PayTpFee record);

    PayTpFee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayTpFee record);

    int updateByPrimaryKey(PayTpFee record);
}