/**
 * 
 */
package com.hp.it.wstax.spider.selenium;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.hp.it.wstax.spider.dao.DealRecordDao;
import com.hp.it.wstax.spider.dao.ProductDescDao;
import com.hp.it.wstax.spider.dao.SalesCommentsDao;
import com.hp.it.wstax.spider.tmall.model.DealRecord;
import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.Constants;
import com.hp.it.wstax.spider.util.DateFormatter;
import com.hp.it.wstax.spider.util.HttpHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 19, 2013
 * @revision
 */
public class TMallDetailPageCrawler {
    
    private String RATE_FILE_NAME = "c:\\report\\ratetable"+new Date().getTime()+".txt";
    
    private String DEAL_FILE_NAME = "C:\\report\\dealrecord"+new Date().getTime()+".txt";
    
    private Date timeStamp = new Date();
    
    private DealRecordDao dealRecordDao = new DealRecordDao();
    
    private SalesCommentsDao salesCommentsDao = new SalesCommentsDao();
    
    private ProductDescDao productDescDao = new ProductDescDao();
    
    public FirefoxDriver fetchData(Product product) throws InterruptedException, IOException, ParseException{
        
        FirefoxDriver firefoxDriver = HttpHelper.fireFoxDriver();
        
        firefoxDriver
                .get(product.getProductUrl());
       System.out.println("opened");
        WebElement element = firefoxDriver.findElement(By.className("J_ReviewsCount"));
        for(int i=0;i<10;i++){
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            Thread.sleep(1000);
        }
        //read product attributes.
        fetchProductDesc(firefoxDriver, product);
        
        
        /*((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(10000);
        ((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");*/
        System.out.println("count:"+element.getText());
        
        WebElement element2 = firefoxDriver.findElement(By.xpath("//a[@href=\"#J_Reviews\"]"));
        
        System.out.println("link:"+element2.getAttribute("href"));
        element2.click();
        Thread.sleep(5000);
        try {
            fetchRatingTable(firefoxDriver,product);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
       
        
        
        List<DealRecord> records = new ArrayList<DealRecord>();
       
        System.out.println("start deal records");
        WebElement salesLink = firefoxDriver.findElement(By.xpath("//a[@href=\"#J_DealRecord\"]"));
        
        salesLink.click();
        System.err.println("1");
        Thread.sleep(5000);
        System.out.println("2");
        WebElement viewThreeMonthSalesRecordsLink;
        try {
            viewThreeMonthSalesRecordsLink = firefoxDriver.findElementById("J_LinkViewAll");
            viewThreeMonthSalesRecordsLink.click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //firefoxDriver.quit();
        }
        
        System.out.println(3);
        Thread.sleep(5000);
        System.out.println(4);
        
        try {
            fetchSalesVolume(firefoxDriver, records, product);
        } catch (Exception e) {
            e.printStackTrace();
            firefoxDriver.quit();
        }
        System.out.println("records size:"+records.size());
        Thread.sleep(10000);
        //FileUtils.writeLines(new File(DEAL_FILE_NAME), records,true);
       //firefoxDriver.quit();
       return firefoxDriver;
    }
    
    private String replaceStr(String productName){
        
        return productName.replace("\\", "_").replace(".", "_").replace(":", "_").replace("/", "_").replace(" ", "_");
    }
    
    public void fetchSalesVolume(FirefoxDriver firefoxDriver, List<DealRecord> records, Product product) throws InterruptedException, ParseException, IOException{
        
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
            System.out.println(record);
            dealRecordDao.save(record.getProductName(), BigDecimal.valueOf(record.getPrice()), Long.valueOf(record.getVolume()), record.getStatus(), record.getConsumerName(), record.getDate(),product.getProductId()) ;  
            //FileUtils.write(new File("c:\\report\\交易记录_TMall_"+replaceStr(product.getProductName()+"_"+DateFormatter.formatDateToStringTMallDeal(timeStamp))+".txt"), record.toString()+"\r\n\r\n",true);
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
                    
                    fetchSalesVolume(firefoxDriver,records,product);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fetchRatingTable(FirefoxDriver firefoxDriver, Product product) throws InterruptedException, IOException{
        WebElement rateGrid = firefoxDriver.findElementByClassName("rate-grid");
        
        List<WebElement> rateLines = rateGrid.findElements(By.tagName("tr"));
        
        for (WebElement rateLine : rateLines) {
            
            String content = rateLine.findElement(By.className("tm-rate-fulltxt")).getText()+"\r\n\r\n";
            
            System.out.println(content);
            
           // FileUtils.write(new File("c:\\report\\评论列表_TMall_"+replaceStr(product.getProductName()+"_"+DateFormatter.formatDateToStringTMallDeal(timeStamp))+".txt"), content.toString(),true);

            salesCommentsDao.saveComments(product, content);
        }
         
        WebElement ratePager = firefoxDriver.findElement(By.className("rate-paginator"));
        
        List<WebElement> links = ratePager.findElements(By.tagName("a"));
        
        for (WebElement pageLink : links) {
            
            if("下一页>>".equals(pageLink.getText()) && null != (pageLink.getAttribute("href"))){
                pageLink.click();
                Thread.sleep(5000);
                fetchRatingTable(firefoxDriver,product);
            }
        }
        System.out.println("finish rating rable....");
    }
    
    private void fetchProductDesc(FirefoxDriver firefoxDriver, Product product) throws UnsupportedEncodingException, IOException{
        
        WebElement productAttrList = firefoxDriver.findElementById("J_AttrUL");
        
        List<WebElement> liTags = productAttrList.findElements(By.tagName("li"));
        
        for (WebElement liTag : liTags) {
            
            String liTitle = liTag.getAttribute("title");
            
            String liText = liTag.getText();
            
            String attrName = liText.split(":")[0];
            
            attrName = attrName.split("：")[0];
            
            product.getProductDescDetails().put(attrName, liTitle);
            
            productDescDao.save(product.getProductId(), attrName, liTitle);
           // FileUtils.write(new File("c:\\report\\产品详情_TMall_"+replaceStr(product.getProductName()+"_"+DateFormatter.formatDateToStringTMallDeal(timeStamp))+".txt"), attrName+":"+liTitle+"\r\n".toString(),true);

        }
        
    }

}
