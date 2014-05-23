package com.hp.it.wstax.spider.temp;

public class Constants {
	
	
	  public static String DB_CONN_URL = "jdbc:vertica://16.158.82.140:5433/Vertica";
	  public static String DB_CONN_URL_BACKUP= "jdbc:vertica://16.158.70.249:5433/Vertica";

	  public static String DB_USER_NAME = "dbadmin";

	  public static String DB_PASSWORD = "password";
	
	 public static String JDBC_DRIVER = "com.vertica.jdbc.Driver";
	 
	 // CREATE TABLE T_BTC_PRODUCT (id Integer NOT NULL, product_name Varchar(511), total_volume Integer, product_url Varchar(10239), vendor_id Integer, category Integer);
	 // CREATE TABLE T_BTC_DEAL_RECORD (id Integer NOT NULL, deal_title Varchar(10239), price Float(15,0), volume Integer, status Varchar(50), customer_name Varchar(50), product_id Integer, deal_date Timestamp);
	 //CREATE TABLE T_BTC_COMMENT (id Integer NOT NULL, comment_content Varchar(20479), product_id Integer);
	// CREATE TABLE Query (id Integer NOT NULL, product_name Varchar(511), total_volume Integer, product_url Long Varchar, vendor_id Integer, category Integer);
	// CREATE TABLE T_BTC_ATTR_DESCRIPTION (id Integer NOT NULL, product_id Integer, attr_name Varchar(50), attr_value Varchar(127));
}
