/**
 * 
 */
package com.hp.it.wstax.spider.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.hp.it.wstax.spider.exception.DBConnException;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 23, 2013
 * @revision
 */
public class JDBCHelper {
    
    public static Connection getConn(){
        
        try {
            
            Class.forName(Constants.JDBC_DRIVER);
            
            Properties connProp = new Properties();
            connProp.put("user", Constants.DB_USER_NAME);
            connProp.put("password", Constants.DB_PASSWORD);
            connProp.put("ConnSettings", "SET LOCALE TO zh_CN");
            
            
            Connection conn = 
            DriverManager.getConnection(Constants.DB_CONN_URL,connProp );
            
            conn.setAutoCommit(false);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DBConnException();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBConnException();
        }
        
    }
    
//    public void insert(String sql, Map<String, Object> )
    
    

}
