package com.gua.open.jdbc.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.gua.open.jdbc.dto.StockDto;

/**
 * 类StockDaoImpl.java的实现描述：TODO 类实现描述
 * 
 * @author weicheng.lwc 2017年6月11日 上午11:05:44
 */
@Service("stockDao")
public class StockDaoImpl implements StockDao, InitializingBean {

//    private DataSource   datasource;

    private JdbcTemplate jdbcTemplate;

    @Override
    public void batchInsert(List<StockDto> stockDtos) {
        final List<StockDto> tempStocklist = stockDtos;
        String sql = "insert into stock_eastmoney(stock_code,stock_name,continuous_blank_plate_quantity,total_increase,sign_profit,crawl_date,modify_time,create_time)"
                     + " values(?,?,?,?,?,?,now(), now())";
        this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public int getBatchSize() {
                return tempStocklist.size();
            }

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, tempStocklist.get(i).getStockCode());
                ps.setString(2, tempStocklist.get(i).getStockName());
                ps.setString(3, tempStocklist.get(i).getContinuousBlankPlateQuantity());
                ps.setFloat(4, tempStocklist.get(i).getTotalIncrease());
                ps.setFloat(5, tempStocklist.get(i).getSignProfit());
                ps.setDate(6, tempStocklist.get(i).getCrawlDate());
            }
        });

    }

    @Override
    public List<StockDto> queryByCrawlDate() {
        List<StockDto> stockDtos = jdbcTemplate.query("select * from stock_eastmoney where to_days(crawl_date)=to_days(now())",
                                                      new RowMapper<StockDto>() {

                                                          @Override
                                                          public StockDto mapRow(ResultSet rs,
                                                                                 int rowNum) throws SQLException {
                                                              StockDto stockDto = new StockDto();
                                                              stockDto.setStockCode(rs.getInt("stock_code"));
                                                              stockDto.setStockName(rs.getString("stock_name"));
                                                              stockDto.setContinuousBlankPlateQuantity(rs.getString("continuous_blank_plate_quantity"));
                                                              stockDto.setTotalIncrease(rs.getFloat("total_increase"));
                                                              stockDto.setSignProfit(rs.getFloat("sign_profit"));
                                                              stockDto.setCrawlDate(rs.getDate("crawl_date"));
                                                              return stockDto;
                                                          }
                                                      });

        return stockDtos;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/wogua_database?useUnicode=true&characterEncoding=UTF8");
        bds.setUsername("root");
        bds.setPassword("123456");
        bds.setMaxActive(50);
        bds.setMaxIdle(10);
        bds.setMaxWait(50);
        bds.setDefaultAutoCommit(true);

//        this.datasource = bds;

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(bds);
        this.jdbcTemplate = jdbcTemplate;
    }

}
