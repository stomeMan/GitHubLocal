package com.hp.it.wstax.spider.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * used for  Vertica JDBC connect
 * @author hezhe
 * @created 
 */
public class Jdbconn {
	
public static  Connection getConn(){
        
        //for backup db
        try {
            
            Class.forName(Constants.JDBC_DRIVER);
            
            Properties connProp = new Properties();
            connProp.put("user", Constants.DB_USER_NAME);
            connProp.put("password", Constants.DB_PASSWORD);
            connProp.put("ConnSettings", "SET LOCALE TO zh_CN");
            Connection conn = 
            DriverManager.getConnection(Constants.DB_CONN_URL_BACKUP,connProp );
            conn.setAutoCommit(false);
            System.out.println("Connect success");
            return conn;
        }catch (Exception e){
        	System.out.println("Connect Exception");
        	e.printStackTrace();
        }
        
        return null;
    }

public static void main(String args[]){
	getConn();
}
}
