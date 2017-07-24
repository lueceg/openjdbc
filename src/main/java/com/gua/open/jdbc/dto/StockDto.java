package com.gua.open.jdbc.dto;

import java.sql.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 类StockDto.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年6月11日 上午10:59:29
 */
public class StockDto {

    private Integer stockCode;

    private String  stockName;

    private String  continuousBlankPlateQuantity;

    private float   totalIncrease;

    private float   signProfit;

    private Date marketDate;

    private Date    crawlDate;

    public Integer getStockCode() {
        return stockCode;
    }

    public void setStockCode(Integer stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getContinuousBlankPlateQuantity() {
        return continuousBlankPlateQuantity;
    }

    public void setContinuousBlankPlateQuantity(String continuousBlankPlateQuantity) {
        this.continuousBlankPlateQuantity = continuousBlankPlateQuantity;
    }

    public float getTotalIncrease() {
        return totalIncrease;
    }

    public void setTotalIncrease(float totalIncrease) {
        this.totalIncrease = totalIncrease;
    }

    public float getSignProfit() {
        return signProfit;
    }

    public void setSignProfit(float signProfit) {
        this.signProfit = signProfit;
    }

    public Date getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(Date marketDate) {
        this.marketDate = marketDate;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
