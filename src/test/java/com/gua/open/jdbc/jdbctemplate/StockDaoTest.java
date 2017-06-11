package com.gua.open.jdbc.jdbctemplate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gua.open.jdbc.dto.StockDto;

/**
 * 类StockDaoTest.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年6月11日 下午12:53:35
 */
public class StockDaoTest {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("db-service-beans.xml");
    
    @Test
    public void testBatchInsert() {
        StockDao stockDao = context.getBean(StockDao.class);
        List<StockDto> stockDtoList = new ArrayList<StockDto>();
        stockDtoList.add(newStockDto(Integer.valueOf(32318), "奥翔药业", "待上市", 13.7F, 1350.75F, new Date(System.currentTimeMillis())));
        stockDtoList.add(newStockDto(Integer.valueOf(32293), "迪贝电气", "已上市", -5.7F, -13.75F, new Date(System.currentTimeMillis())));
        stockDao.batchInsert(stockDtoList);
    }
    
    @Test
    public void testQueryByCrawlDate() {
        StockDao stockDao = context.getBean(StockDao.class);
        List<StockDto> stockDtoList = stockDao.queryByCrawlDate();
        for (StockDto stockDto : stockDtoList) {
            System.out.println(stockDto.toString());
        }
    }
    
    @Test
    public void testClearTable() {
        StockDao stockDao = context.getBean(StockDao.class);
        stockDao.clearTable();
    }

    private static StockDto newStockDto(Integer stockCode, String stockName, String continuousBlankPlateQuantity,
                                 float totalIncrease, float signProfit, Date crawlDate) {
        
        StockDto stockDto = new StockDto();
        stockDto.setStockCode(stockCode);
        stockDto.setStockName(stockName);
        stockDto.setContinuousBlankPlateQuantity(continuousBlankPlateQuantity);
        stockDto.setTotalIncrease(totalIncrease);
        stockDto.setSignProfit(signProfit);
        stockDto.setCrawlDate(crawlDate);
        return stockDto;

    }

}
