package com.gua.open.mybatis.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class StockDao {
    private Integer stockCode;

    private String stockName;

    private String continuousBlankPlateQuantity;

    private Float totalIncrease;

    private Float signProfit;

    private Date marketDate;

    private Date crawlDate;

    private Date modifyTime;

    private Date createTime;

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
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public String getContinuousBlankPlateQuantity() {
        return continuousBlankPlateQuantity;
    }

    public void setContinuousBlankPlateQuantity(String continuousBlankPlateQuantity) {
        this.continuousBlankPlateQuantity = continuousBlankPlateQuantity == null ? null : continuousBlankPlateQuantity.trim();
    }

    public Float getTotalIncrease() {
        return totalIncrease;
    }

    public void setTotalIncrease(Float totalIncrease) {
        this.totalIncrease = totalIncrease;
    }

    public Float getSignProfit() {
        return signProfit;
    }

    public void setSignProfit(Float signProfit) {
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stockCode", stockCode)
                .append("stockName", stockName)
                .append("continuousBlankPlateQuantity", continuousBlankPlateQuantity)
                .append("totalIncrease", totalIncrease)
                .append("signProfit", signProfit)
                .append("marketDate", marketDate)
                .append("crawlDate", crawlDate)
                .append("modifyTime", modifyTime)
                .append("createTime", createTime)
                .toString();
    }
}