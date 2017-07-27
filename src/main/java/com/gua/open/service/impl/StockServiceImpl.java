package com.gua.open.service.impl;

import com.gua.open.mybatis.StockDaoMapper;
import com.gua.open.mybatis.dto.StockDao;
import com.gua.open.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wogua on 2017/7/25.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDaoMapper stockDaoMapper;

    public int deleteByPrimaryKey(Integer stockCode) {
        return stockDaoMapper.deleteByPrimaryKey(stockCode);
    }

    public int insert(StockDao record) {
        return stockDaoMapper.insert(record);
    }

    public int insertSelective(StockDao record) {
        return stockDaoMapper.insertSelective(record);
    }

    public StockDao selectByPrimaryKey(Integer stockCode) {
        return stockDaoMapper.selectByPrimaryKey(stockCode);
    }

    public int updateByPrimaryKeySelective(StockDao record) {
        return stockDaoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(StockDao record) {
        return stockDaoMapper.updateByPrimaryKey(record);
    }

    public int insertBatch(List<StockDao> recordList) {
        return stockDaoMapper.insertBatch(recordList);
    }

    public int updateBatch(List<StockDao> recordList) {
        return stockDaoMapper.updateBatch(recordList);
    }

    public int deleteBatch(List<Integer> stockCodeList) {
        return stockDaoMapper.deleteBatch(stockCodeList);
    }

    public int deleteAll() {
        return stockDaoMapper.deleteAll();
    }
}
