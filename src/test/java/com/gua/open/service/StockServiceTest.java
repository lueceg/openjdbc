package com.gua.open.service;

import com.gua.open.mybatis.dto.StockDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wogua on 2017/7/25.
 */
public class StockServiceTest {

    private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"db-service-beans.xml","spring-mybatis.xml"});

    @Test
    public void testSelectByPrimaryKey() {
        StockService stockService = context.getBean(StockService.class);
        StockDao stockDao = stockService.selectByPrimaryKey(2335);
        System.out.println(stockDao);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        StockService stockService = context.getBean(StockService.class);
        int i = stockService.deleteByPrimaryKey(132293);
        System.out.println(i);
    }

    @Test
    public void testInsertBatch() {
        StockService stockService = context.getBean(StockService.class);
        List<StockDao> stockDtoList = new ArrayList<StockDao>();
        stockDtoList.add(newStockDao(Integer.valueOf(132318), "奥翔药业", "待上市", 13.7F, 1350.75F, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        stockDtoList.add(newStockDao(Integer.valueOf(132293), "迪贝电气", "已上市", -5.7F, -13.75F, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        int i = stockService.insertBatch(stockDtoList);
        System.out.println(i);
    }

    @Test
    public void testUpdataBatch() {
        StockService stockService = context.getBean(StockService.class);
        List<StockDao> stockDtoList = new ArrayList<StockDao>();
        stockDtoList.add(newStockDao(Integer.valueOf(132318), "奥翔药业2", "未上市", 13.77F, 1350.757F, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        stockDtoList.add(newStockDao(Integer.valueOf(132293), "迪贝电气", "已上市", -5.7F, -13.75F, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        int i = stockService.updateBatch(stockDtoList);
        System.out.println(i);
    }

    @Test
    public void testDeleteBatch() {
        StockService stockService = context.getBean(StockService.class);
        List<Integer> stockCodeList = new ArrayList<Integer>();
        stockCodeList.add(132318);
        stockCodeList.add(132293);
        int i = stockService.deleteBatch(stockCodeList);
        System.out.println(i);
    }

    private static StockDao newStockDao(Integer stockCode, String stockName, String continuousBlankPlateQuantity,
                                        float totalIncrease, float signProfit, Date marketDate, Date crawlDate) {

        StockDao stockDto = new StockDao();
        stockDto.setStockCode(stockCode);
        stockDto.setStockName(stockName);
        stockDto.setContinuousBlankPlateQuantity(continuousBlankPlateQuantity);
        stockDto.setTotalIncrease(totalIncrease);
        stockDto.setSignProfit(signProfit);
        stockDto.setMarketDate(marketDate);
        stockDto.setCrawlDate(crawlDate);
        return stockDto;

    }
}
