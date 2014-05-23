/**
 * 
 */
package com.hp.it.wstax.spider.selenium;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;

import com.hp.it.wstax.spider.tmall.model.DealRecord;
import com.hp.it.wstax.spider.util.DateFormatter;
import com.hp.it.wstax.spider.util.HttpHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 19, 2013
 * @revision
 */
public class TencentMicroblogComments {
    
//    private String RATE_FILE_NAME = "c:\\report\\HpHrInfo";
    private String RATE_FILE_NAME = "c:\\report\\";
    
    private String DEAL_FILE_NAME = "C:\\report\\dealrecord"+new Date().getTime()+".txt";
    private String[] fromTimeArr={"2014年01月07日","2014年01月17日","2014年01月27日"};
    private String[] toTimeArr={"2014年1月0日16","2014年01月26日","2013年02月06日"};
    
    public static void main(String[] args) throws InterruptedException, IOException, ParseException{
		TencentMicroblogComments tm = new TencentMicroblogComments();
		//tm.fetchData("http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-2633651508.58.QfwPXI&id=22261103471&rn=0ad159b67904adc0bb66158a052b4a58");
		//tm.fetchData("http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-2633651508.68.mII4xS&id=19973793651&rn=1607998a11be249a1171febe323ffc9d");
		//tm.fetchData("http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-2633651508.73.mII4xS&id=19520757237&rn=1607998a11be249a1171febe323ffc9d");
		//tm.fetchData("http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-2633651508.78.mII4xS&id=19516334486&rn=1607998a11be249a1171febe323ffc9d")"惠普 待遇","惠普  福利","惠普 加薪","惠普 裁员","惠普 考核","惠普 年终奖","惠普 bonus ","惠普 升职 ","惠普 休假","惠普 实习","惠普 加班","惠普 离职","惠普 辞职","惠普 培训","惠普  工资",;
		String[] keys= {"惠普"};
		String qqEmail="624757102@qq.com";//enter your qq email
		String qqPassword="ghl,.880501";//enter your qq email password
		String url = "http://ui.ptlogin2.qq.com/cgi-bin/login?appid=46000101&style=13&lang=&low_login=1&hide_title_bar=1&hide_close_icon=1&self_regurl=http%3A//reg.t.qq.com/index.php&s_url=http%3A%2F%2Ft.qq.com&daid=6";
		FirefoxDriver firefoxDriver = HttpHelper.fireFoxDriver();
		tm.login(url, qqEmail, qqPassword,firefoxDriver);
		String [] urls={"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140420%2C20140423",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140413%2C20140419",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140406%2C20140412",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140330%2C20140405",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140323%2C20140329",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140316%2C20140322",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140309%2C20140315",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140302%2C20140308",
				"http://search.t.qq.com/index.php?pos=241&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140224%2C20140301"};
		firefoxDriver.get(urls[0]);
		for(String key:keys){
			tm.fetchData(url,key,firefoxDriver);
		}
		firefoxDriver.quit();
		System.out.println("-----------------------------------------TencentMicroblogComments end---------------------------------------------------");
		//http://ui.ptlogin2.qq.com/cgi-bin/login?appid=46000101&style=13&lang=&low_login=1&hide_title_bar=1&hide_close_icon=1&self_regurl=http%3A//reg.t.qq.com/index.php&s_url=http%3A%2F%2Ft.qq.com&daid=6
		
    }
    private void login(String url,String qqEmail,String qqPassword, FirefoxDriver firefoxDriver) throws InterruptedException{
         firefoxDriver.get(url);
         System.out.println("opened");
          for(int i=0;i<5;i++){
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              Thread.sleep(1000);
          }
          WebElement userNameInput = firefoxDriver.findElement(By.id("u"));
          userNameInput.sendKeys(qqEmail);
          WebElement passwordInput = firefoxDriver.findElement(By.id("p"));
          passwordInput.sendKeys(qqPassword);
          WebElement loginSumbit = firefoxDriver.findElement(By.id("login_button"));
          loginSumbit.click();
          Thread.sleep(4000);
          
    }
    public void fetchData(String url,String key,FirefoxDriver firefoxDriver) throws InterruptedException, IOException, ParseException{
        
        WebElement element = firefoxDriver.findElement(By.id("searchKey"));
        /*((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(10000);
        ((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");*/
       // System.out.println("count:"+element.getText());
     
        WebElement element2 = firefoxDriver.findElement(By.className("inputBtn"));
        element.sendKeys(key);
        element2.submit();//搜索按钮开始搜索
        WebElement showAdvance = firefoxDriver.findElement(By.id("btn_advance"));
        //System.out.println("link:"+element2.getAttribute("href"));
        try {
        	showAdvance.click();
            int al=fromTimeArr.length;
            for(int i=0;i<al;i++){
            	WebElement setTimeBtn=null;
            	List<WebElement> es = firefoxDriver.findElements(By.tagName("a"));
            
                for(WebElement e:es){
                	String te=e.getText();
                	if(te.trim().length()>0){
                		System.out.println(te);
                	}
                	if(te!=null&&(te.contains("时间不限")|te.matches("\\d\\d\\d\\d.\\d\\d.\\d\\d-\\d\\d.\\d\\d.\\d\\d"))){
                		e.click();
                		break;
                	}
                }
               es = firefoxDriver.findElements(By.tagName("a"));
                for(WebElement e:es){
                	String te=e.getText();
                	if(te!=null&&(te.contains("指定时间")|te.matches("\\d\\d\\d\\d.\\d\\d.\\d\\d-\\d\\d.\\d\\d.\\d\\d"))){
                		setTimeBtn=e;
                		break;
                	}
                }
                setTimeBtn.click();//跳出确定按钮,开始选择时间
                WebElement fromTimeInput = firefoxDriver.findElement(By.id("s_time_txt_from"));
                WebElement toTimeInput = firefoxDriver.findElement(By.id("s_time_txt_to"));
                WebElement btn = firefoxDriver.findElement(By.className("btn_dlg_ok"));
        		fromTimeInput.sendKeys(fromTimeArr[i]);
        		toTimeInput.sendKeys(toTimeArr[i]);
            	try{
            		btn.click();
            		element2 = firefoxDriver.findElement(By.className("inputBtn"));
          			element2.submit();//搜索按钮开始搜索
          			fetchRatingTable(firefoxDriver,key);
            	}catch(Exception e){
            		  e.printStackTrace();
            	}
        	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       
        
        /*
        List<DealRecord> records = new ArrayList<DealRecord>();
       
        System.out.println("start deal records");
        WebElement salesLink = firefoxDriver.findElement(By.xpath("//a[@href=\"#J_DealRecord\"]"));
        
        salesLink.click();
        System.err.println("1");
        Thread.sleep(5000);
        System.out.println("2");
        WebElement viewThreeMonthSalesRecordsLink = firefoxDriver.findElementById("J_LinkViewAll");
        
        viewThreeMonthSalesRecordsLink.click();
        System.out.println(3);
        Thread.sleep(5000);
        System.out.println(4);
        
        fetchSalesVolume(firefoxDriver, records);
        System.out.println("records size:"+records.size());
        Thread.sleep(10000);
        FileUtils.writeLines(new File(DEAL_FILE_NAME), records,true);*/
    }
    
    public void fetchSalesVolume(FirefoxDriver firefoxDriver, List<DealRecord> records) throws InterruptedException, ParseException{
        
        WebElement tableDealRecord = firefoxDriver.findElementByClassName("table-deal-record");
        
        List<WebElement> rows = tableDealRecord.findElements(By.tagName("tr"));
        
        for(int i=1; i<rows.size();i++){
            
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            
            DealRecord record = new DealRecord();
            record.setConsumerName(columns.get(0).getText());
            record.setProductName(columns.get(1).getText());
            record.setPrice(Double.valueOf(columns.get(2).getText()));
            record.setVolume(Integer.valueOf(columns.get(3).getText()));
            record.setDate(DateFormatter.formatStringToDateTMallDeal(columns.get(4).getText()));
            record.setStatus(columns.get(5).getText());
            
            records.add(record);
            
        }
       
        try {
            
            WebElement bottomLine = firefoxDriver.findElementByClassName("pagination").findElement(By.className("page-bottom"));
            
            List<WebElement> links = bottomLine.findElements(By.tagName("a"));
            
//            WebElement nextPageLink = links.get((links.size()-1));
            for (WebElement link : links) {
                if("下一页".equals(link.getText())){
                    
                    System.out.println("page change start");
                    link.click();
                    System.out.println("page change end");
                    Thread.sleep(5000);
                    
                    fetchSalesVolume(firefoxDriver,records);
                }
            }
            
           // WebElement nextPageLink = firefoxDriver.findElementByClassName("page-next");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fetchRatingTable(FirefoxDriver firefoxDriver,String key) throws InterruptedException, IOException{
        WebElement rateGrid = firefoxDriver.findElementById("talkList");
        
        List<WebElement> rateLines = rateGrid.findElements(By.tagName("li"));
        String tab="\t";
        String changeLine="\n";
        StringBuilder sb=null;
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
  		SimpleDateFormat newsdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
	    for (WebElement rateLine : rateLines) {
	        	sb=new StringBuilder();
	        	String msgCnt=rateLine.findElement(By.className("msgCnt")).getText();
	        	String userName=rateLine.findElement(By.className("userName")).getText();
	        	String time=rateLine.findElement(By.className("time")).getAttribute("title");
	        	rateLine.findElement(By.className("time")).getAttribute("");
	        	try {
	        	date = sdf.parse(time);
	        	} catch (ParseException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    			date=new Date();
	    		}
        		time=newsdf.format(date);
	        	sb.append(userName).append(tab).append(time).append(tab).append(msgCnt).append(changeLine);
	            System.out.println(sb);
	            FileUtils.write(new File(RATE_FILE_NAME+"HpHrInfo"+".txt"),sb ,true);
	        }
		
		
         System.out.println("============================================================= one page end=============================================================");
        List<WebElement> links = firefoxDriver.findElements(By.className("pageBtn"));
        try{
        	for (WebElement pageLink : links) {
            	System.out.println("text:"+pageLink.getText()+"||"+("下一页 >>".equals(pageLink.getText())) +"||"+(null != (pageLink.getAttribute("href")))+""+pageLink.getAttribute("href"));
                if("下一页 >>".equals(pageLink.getText()) && null != (pageLink.getAttribute("href"))){
            		pageLink.click();
                    Thread.sleep(5000);
                    fetchRatingTable(firefoxDriver ,key);
                }
            }
        }catch(Exception  e){
        	System.out.println();
        	e.printStackTrace();
        }
        System.out.println("=============================================================all of the page read end=============================================================");
        
        
        //List<WebElement> links = ratePager.findElements(By.tagName("a"));
        
       /* WebElement nextPageLink = firefoxDriver.findElementByLinkText("下一页>>");
        
        if(null != (nextPageLink.getAttribute("href"))){
            nextPageLink.click();
            fetchRatingTable(firefoxDriver);
        }*/
      
        /*for (WebElement pageLink : links) {
            
            if("下一页>>".equals(pageLink.getText()) && null != (pageLink.getAttribute("href"))){
                pageLink.click();
                Thread.sleep(5000);
                fetchRatingTable(firefoxDriver);
            }
        }*/
    }

}
