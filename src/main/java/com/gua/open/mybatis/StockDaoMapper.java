package com.gua.open.mybatis;

import com.gua.open.mybatis.dto.StockDao;

import java.util.List;

public interface StockDaoMapper {
    int deleteByPrimaryKey(Integer stockCode);

    int insert(StockDao record);

    int insertSelective(StockDao record);

    StockDao selectByPrimaryKey(Integer stockCode);

    List<StockDao> selectAll();

    int updateByPrimaryKeySelective(StockDao record);

    int updateByPrimaryKey(StockDao record);

    int insertBatch(List<StockDao> recordList);

    int updateBatch(List<StockDao> recordList);

    int deleteBatch(List<Integer> stockCodeList);

    int deleteAll();
}