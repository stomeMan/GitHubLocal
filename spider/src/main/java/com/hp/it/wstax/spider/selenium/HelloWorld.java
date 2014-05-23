/**
 * 
 */
package com.hp.it.wstax.spider.selenium;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hp.it.wstax.spider.tmall.model.DealRecord;
import com.hp.it.wstax.spider.util.DateFormatter;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 18, 2013
 * @revision
 */
public class HelloWorld {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver
                .get("http://detail.tmall.com/item.htm?spm=a1z10.1.w5003-5137640052.3.v6MQN1&id=17405410314&rn=eca548300bb5123015b4139637499a30&scene=taobao_shop");
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
        /*((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(10000);
        ((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");*/
        System.out.println("count:"+element.getText());
        
        WebElement element2 = firefoxDriver.findElement(By.xpath("//a[@href=\"#J_Reviews\"]"));
        
        System.out.println("link:"+element2.getAttribute("href"));
        element2.click();
        
        /*WebElement rateGrid = firefoxDriver.findElementByClassName("rate-grid");
        
        List<WebElement> rateLines = rateGrid.findElements(By.tagName("tr"));
        
        for (WebElement rateLine : rateLines) {
            System.out.println(rateLine.findElement(By.className("tm-rate-fulltxt")).getText());
        }
        
        WebElement ratePager = firefoxDriver.findElement(By.className("rate-paginator"));
        
        List<WebElement> links = firefoxDriver.findElementsByTagName("a");
        
        for (WebElement pageLink : links) {
            if("下一页>>".equals(pageLink.getText())){
                pageLink.click();
            }
        }*/
        
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
        WebElement tableDealRecord = firefoxDriver.findElementByClassName("table-deal-record");
        
        List<WebElement> rows = tableDealRecord.findElements(By.tagName("tr"));
        
        List<DealRecord> records = new ArrayList<DealRecord>();
        
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
            records.add(record);
            
        }
      // firefoxDriver.quit();
    }
}
