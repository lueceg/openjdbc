package com.gua.open.service;

import com.gua.open.mybatis.dto.StockDao;

import java.util.List;

/**
 * Created by wogua on 2017/7/25.
 */
public interface StockService {

    int deleteByPrimaryKey(Integer stockCode);

    int insert(StockDao record);

    int insertSelective(StockDao record);

    StockDao selectByPrimaryKey(Integer stockCode);

    int updateByPrimaryKeySelective(StockDao record);

    int updateByPrimaryKey(StockDao record);

    int insertBatch(List<StockDao> recordList);

    int updateBatch(List<StockDao> recordList);

    int deleteBatch(List<Integer> stockCodeList);

    int deleteAll();
}
