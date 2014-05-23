/**
 * 
 */
package com.hp.it.wstax.spider.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.hp.it.wstax.spider.exception.DBConnException;
import com.hp.it.wstax.spider.util.JDBCHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 23, 2013
 * @revision
 */
public class DealRecordDao {
    /**
     * 
     * @param dealTitle
     * @param price
     * @param volume
     * @param status
     * @param customerName
     */
    public void save(String dealTitle, BigDecimal price, Long volume, String status, String customerName, Date date, Long productId){
        
       Connection conn = JDBCHelper.getConn(); 
       
       String sql = "insert into T_BTC_DEAL_RECORD(deal_title, price, volume, status, customer_name, product_id,deal_date) values(?,?,?,?,?,?,?)";
       
       try {
        
           PreparedStatement pstmt = conn.prepareStatement(sql);
           
           pstmt.setString(1, dealTitle);
           pstmt.setBigDecimal(2, price);
           pstmt.setLong(3, volume);
           pstmt.setString(4, status);
           pstmt.setString(5, customerName);
           pstmt.setLong(6, productId);
           pstmt.setDate(7, new java.sql.Date(date.getTime()));
           pstmt.executeUpdate();
           
           conn.commit();
        
    }catch (SQLException e) {
        e.printStackTrace();
        try {
            conn.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        throw new DBConnException(e.getMessage(), e);
    } finally {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
       
       
    }

}
