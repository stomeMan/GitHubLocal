package com.hp.it.wstax.spider.temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *  used for import the sina && tengcent weibo data into Vertiaca DB
 * @author hezhe
 * @created 2/19/2014
 */
public class importDataToVerticaDB {
	
	private static BufferedReader br = null;
	private static int count = 0;
	
	public static void main(String args[]) throws IOException, SQLException{
		//new importDataToVerticaDB().readFiles();
		getDataFromVertica();
	}
	
	/**
	 *  read the .txt file from local disk..
	 * @throws IOException 
	 * @throws SQLException 
	 */
	
	protected void readFiles() throws IOException, SQLException{
		try{
			File f = new File("C:\\dev_hezhe\\totaltxts.txt");
			InputStream in = new FileInputStream(f);
			InputStreamReader  read = new InputStreamReader(in);
			 br = new BufferedReader(read);
			String line = null;
			while( (line=br.readLine()) != null){
				System.out.println(line);
				//insert into DB 
				store_VerticaDB(line);
				count ++;
			}
			System.out.println("total count: " + count);
		} catch(IOException e){
			System.out.println("hezejiang Exception IO ");
			e.printStackTrace();
		} finally{
			br.close();
		}
	}
	
	/**
	 * store in the Vertica DB 
	 * @throws SQLException 
	 */
	private void store_VerticaDB(String line) throws SQLException{
		
		Connection conn = Jdbconn.getConn();
		String sql_Insert = "INSERT INTO Sina_TengcentDatas (content) VALUES ( ?)";
		try{
			PreparedStatement psmt = conn.prepareStatement(sql_Insert);
			//ID auto_increment, just insert the content..
			psmt.setString(1, line);
			psmt.executeUpdate();
			conn.commit();
			System.out.println("Insert SUccess!");
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			conn.close();
		}
		
	}
	
	/**
	 * test the correctness of data (check if messy code )
	 * @throws SQLException 
	 */
	public static void getDataFromVertica() throws SQLException{
		Connection conn = Jdbconn.getConn();
		String sql_Query = "select * from Sina_TengcentDatas where content like '%你好，请问惠普笔记本电脑的无线网络开关开 ...%'";
		ResultSet rs = null;
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql_Query);
			rs = pstmt.executeQuery();
			System.out.println("Query top 100 records =====Iterator the ResultSet from DB");
			while(rs.next()){
				int column = rs.getInt(1);
				String content = rs.getString(2);
				System.out.println("column: " + column + "content: " + content);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			conn.close();
		}
	}
	
}
