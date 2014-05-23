/**
 * 
 */
package com.hp.it.wstax.spider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hp.it.wstax.spider.exception.DBConnException;
import com.hp.it.wstax.spider.util.JDBCHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 23, 2013
 * @revision
 */
public class ProductDao {
    /**
     * Save product to DB
     * @param ProductName
     * @param ProductUrl
     * @param totalVolume
     * @param vendorId
     * @param categoryId
     */
    public Long save(String productName, String productUrl, Integer totalVolume, Integer categoryId, Integer vendorId){
        Connection conn = JDBCHelper.getConn();
        
        String sql = "insert into T_BTC_PRODUCT(product_name, total_volume, product_url,vendor_id,category) values(?,?,?,?,?)";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, productName);
            pstmt.setObject(2, totalVolume);
            pstmt.setString(3, productUrl);
            pstmt.setInt(4, vendorId.intValue());
            pstmt.setInt(5, categoryId.intValue());
            
            pstmt.executeUpdate();
            
            Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery("select  IDENT_CURRENT('T_BTC_PRODUCT') ");
            ResultSet rs = stmt.executeQuery("select LAST_INSERT_ID() ");
            rs.next();
            Long id = rs.getLong(1);
            
            conn.commit();
            return id;
           
        } catch (SQLException e) {
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
    
    public List<String> getNameList(){
        Connection conn = JDBCHelper.getConn();
        
        List<String> nameList = new ArrayList<String>();
        try {
           
            
            Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery("select  IDENT_CURRENT('T_BTC_PRODUCT') ");
            ResultSet rs = stmt.executeQuery("select * from T_BTC_PRODUCT ");
            while(rs.next()){
                
                String name = rs.getString(2);
                
                nameList.add(name);
                
            }
            
            return nameList;
           
        } catch (SQLException e) {
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
