package com.dao;

import com.vo.TDaHyfl;

import java.util.List;

public interface TDaHyflDAO {
    void insert(TDaHyfl record);

    List<TDaHyfl> findAll();
}