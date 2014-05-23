package com.hp.it.wstax.spider.selenium;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hp.it.wstax.spider.tmall.model.*;
import com.hp.it.wstax.spider.util.DateFormatter;

/**
 * @description used for retriving the top products of Lenovo , get the customer evaluation &&  deal record ,
 * 						Here i use the singleton Model to fulfill that.
 * @created  12/23/2013
 * @author  <a href="mailto:zhe-jiang.he@hp.com">He Zhe-Jiang</a>
 *
 */
public class TopProds_Lenovo {
	
	private TopProds_Lenovo(){
		
	}
	
	private static TopProds_Lenovo singlenInstance_Leno = null;
	
	public static TopProds_Lenovo getSinglenInstance_Leno(){
		if (singlenInstance_Leno == null)
			singlenInstance_Leno = new TopProds_Lenovo();
		return singlenInstance_Leno;
	}
	
	Date d = new Date();
	protected String Deal_Record_Name  =  "C:\\LenovoData\\Deal_Record_" + d.getTime() + ".txt";
	protected String Evaluate_Record_Name = "C:\\LenovoData\\Evaluate_Record_" + d.getTime() + ".txt";
	
	/**
	 * @description Fetch data from webSite
	 * @exception InterruptedException, IOException, ParseException
	 */
	public void fetchData(String url, int index_Lable) throws InterruptedException, IOException, ParseException {
		
		if (url == null || "".equals(url)) {
			System.out.println("==========================url can not be null");
			return ;
		}
		FirefoxDriver f_D = new FirefoxDriver();
		f_D.get(url);
		System.out.println("=============================Firefox explore has been opened successfully !");
		//overwrite the constant to get the special filename with tag
		Evaluate_Record_Name = "C:\\LenovoData\\Evaluate_Record_" +index_Lable+"_"+ d.getTime() + ".txt";
		
		//simulate the user press the "down" key when they scan the webpage....hahha 
		for (int i = 0; i<=9; i++) {
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			f_D.getKeyboard().pressKey(Keys.PAGE_DOWN);
			Thread.sleep(1000L);
		}
		Thread.sleep(3000L);
		//aquired the Total user evaluation by className tag
		WebElement we = f_D.findElement(By.className("J_ReviewsCount"));
		System.out.println("================================Total user evaluation :    " + we.getText());
		//aquired the detail user evaluation items by simulating get the HyperLink and then click it..
		WebElement evalLink = f_D.findElement(By.xpath("//a[@href=\"#J_Reviews\"]"));
		System.out.println("================================click url:" + evalLink.getAttribute("href") );
		evalLink.click();
		Thread.sleep(6000L);
		fetchEvaluationList(f_D,index_Lable);
		System.out.println("==================fetchEvaluationList complete!");
		
		//aquired the monthly  deal _records by simulating get the HyperLink and then click it.. too haha  ^.^
		List<DealRecord> dealRecordList = new ArrayList<DealRecord>();
		DealRecord dealRecord = new DealRecord();
		WebElement recordLink = f_D.findElement(By.xpath("//a[@href=\"#J_DealRecord\"]"));
		WebElement records_Count = f_D.findElement(By.className("J_MonSales"));
		System.out.println("================================J_MonSales: " + records_Count.getText());
		System.out.println("================================click url: "+ recordLink.getAttribute("href"));
		recordLink.click();
		fetchMonthlyDealRecord(f_D,dealRecord,dealRecordList,index_Lable);
		
		//quit the firefox 
		f_D.quit();
		
		//End of the current cycle to the next
		
		
	}
	
	/**
	 * @description  Method for getting  the detailed customer evaluation item list
	 */
	private void  fetchEvaluationList (FirefoxDriver f_D, int index_Lable) throws InterruptedException, IOException {
		System.out.println("============================== fetchEvaluationList method  start");
		//get the DIV className  for customer evaluation item
		WebElement divClass = f_D.findElementByClassName("rate-grid");
		//get the all ''Tr'' tag under Div "rate-grid" 
		List<WebElement> trLines = divClass.findElements(By.tagName("tr"));
		//iterate trLines , get the customer evaluatiion each line (tr)
		for (WebElement trLine : trLines) {
			String trLineContent = trLine.findElement(By.className("tm-rate-fulltxt")).getText() + "\r\n";
			//write to the local disk
			FileUtils.write(new File(Evaluate_Record_Name), trLineContent, true);
		}
		//deal paging data
		WebElement paginator = f_D.findElement(By.className("rate-paginator"));
		List<WebElement> links = paginator.findElements(By.tagName("a"));
		for (WebElement link : links) {
			if ("下一页>>".equals(link.getText()) && null != link.getAttribute("href")) {
				link.click();
				Thread.sleep(8000L);
				fetchEvaluationList(f_D,index_Lable);
				
			}
		}
	}
	
	/**
	 * @throws ParseException 
	 * @throws InterruptedException 
	 * @description Method for getting the monthly deal record for product
	 */
	private void fetchMonthlyDealRecord( FirefoxDriver f_D, DealRecord dealRecord, List<DealRecord> l, int index_Lable ) throws  ParseException, InterruptedException {
		System.out.println("==================fetchMonthlyDealRecord Method start!");
		//overwrite the constant to get the special filename with tag
		Deal_Record_Name = "C:\\LenovoData\\Deal_Record_" +index_Lable+"_"+ d.getTime() + ".txt";
		Thread.sleep(2000L);
		try{
			WebElement dealRecordTable = f_D.findElement(By.className("table-deal-record"));
			//get all lines(tr) of the table
			List<WebElement> rows = dealRecordTable.findElements(By.tagName("tr"));
			
			for (int i=1; i<rows.size(); i++){
				//get all lines(td) of each ''tr''
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				dealRecord = new DealRecord();
				dealRecord.setConsumerName(columns.get(0).getText());
				dealRecord.setProductName(columns.get(1).getText());
				dealRecord.setPrice(Double.valueOf(columns.get(2).getText()));
				dealRecord.setVolume(Integer.valueOf(columns.get(3).getText()));
				dealRecord.setDate(DateFormatter.formatStringToDateTMallDeal(columns.get(4).getText()));
				dealRecord.setStatus(columns.get(5).getText());
				l.add(dealRecord);
				System.out.println("=================================dealRecord"+ dealRecord);
				Thread.sleep(3000L);
			}
		} catch (ParseException n) {
			System.out.println(n.getMessage() + "may type interchange incorrect---zhe-jiang.he@hp.com");
		}
		
		//considering the paging data like 1,2,3.........last page.... haha  you know..
		try{
			WebElement pagination = f_D.findElement(By.className("pagination")).findElement(By.className("page-bottom"));
			List<WebElement> links = pagination.findElements(By.tagName("a"));
			for (WebElement link : links) {
				if ("下一页".equals(link.getText()) && null != link.getAttribute("href")) {
					link.click();
					Thread.sleep(6000L);
					//get the next page and fetch its data...
					fetchMonthlyDealRecord(f_D,dealRecord,l,index_Lable);
				}
			}
		} catch (InterruptedException n) {
			System.out.println(n.getMessage() + "may thread interrupted ---zhe-jiang.he@hp.com");
		}
		
		try {
			FileUtils.writeLines(new File(Deal_Record_Name), l, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("================================fetchMonthlyDealRecord  over");
		
	}
}
