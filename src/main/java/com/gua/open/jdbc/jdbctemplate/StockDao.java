package com.gua.open.jdbc.jdbctemplate;

import java.util.List;

import com.gua.open.jdbc.dto.StockDto;

/**
 * 类StockDao.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年6月11日 上午11:02:34
 */
public interface StockDao {
    
    public void batchInsert(List<StockDto> stockDtos);
    
    public List<StockDto> queryByCrawlDate();
    
    public void clearTable();
}
