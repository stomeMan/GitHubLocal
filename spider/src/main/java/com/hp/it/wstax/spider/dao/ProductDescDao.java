/**
 * 
 */
package com.hp.it.wstax.spider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hp.it.wstax.spider.util.JDBCHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 26, 2013
 * @revision
 */
public class ProductDescDao {
    
    public void save(Long productId, String attrName, String attrValue){
        Connection conn = JDBCHelper.getConn();
        String sql = "insert into T_BTC_ATTR_DESCRIPTION(product_id,attr_name,attr_value) values(?,?,?)";
        
        try {
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, productId.intValue());
            
            pstmt.setString(2, attrName);
            
            pstmt.setString(3, attrValue);
            
            pstmt.executeUpdate();
            
            conn.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
