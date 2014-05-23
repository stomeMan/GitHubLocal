/**
 * 
 */
package com.hp.it.wstax.spider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hp.it.wstax.spider.exception.DBConnException;
import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.JDBCHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 23, 2013
 * @revision
 */
public class SalesCommentsDao {
    
    public void saveComments(Product product, String comments){
        Long productId = product.getProductId();
        Connection conn = JDBCHelper.getConn();
        
        String sql = "insert into T_BTC_COMMENT(comment_content, product_id) values(?,?)";
        
        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, comments);
            
            pstmt.setLong(2, productId);
            
            pstmt.executeUpdate();
            
            conn.commit();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            
            throw new DBConnException(e.getMessage(),e);
            
        } finally{
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        
        
    }

}
