/**
 *@Project Name:spider 
 *@Package Name:com.hp.it.wstax.spider.selenium
 *@File Name:JingDong.java
 *@Author: yejieb
 *@Date: 2013-12-20 上午10:55:47
 *@Copyright: HP All Rights Reserved.
 */

package com.hp.it.wstax.spider.selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *@ClassName: JingDong
 *@Description: 
 *   1.[Type]:add/modify [Author]:yejieb [Email]:***@hp.com [RequirementID]:***** [Date]:2013-12-20 上午10:55:47 
 *   2.[Program Function]:
 *   3.[Design Principle]:
 *   4.[Look Out]:
 *@Version: 
 */
public class JingDong {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver
                .get("http://item.jd.com/1000485.html?utm_source=c.duomai.com&utm_medium=tuiguang&utm_campaign=t_16282_86033201&utm_term=39edb6d729a04932b157edfd7de7aeeb");
       System.out.println("opened");
        WebElement element = firefoxDriver.findElement(By.className("hl_blue"));
        
        ((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Thread.sleep(10000);
        ((JavascriptExecutor) firefoxDriver).executeScript("window.scrollTo(0,document.body.scrollHeight);");

        element.click();
        //买家印象 好评率
        WebElement element2 = firefoxDriver.findElement(By.id("comment"));
        System.out.println("count:"+element2.getText());
        //商品评论 第一页

        WebElement element4 = firefoxDriver.findElement(By.id("comment-0"));
        System.out.println("count:"+element4.getText());
        
        Thread.sleep(10000);
        //循环访问下一页
        getAllComments(2,firefoxDriver);
        
        firefoxDriver.quit();
        
    }
    
   public static void getAllComments(int pageNumber,WebDriver firefoxDriver) throws InterruptedException{
	   System.out.println("========================================================================");
	   System.out.println("===============================本次是第"+pageNumber+"页====================");
	   System.out.println("========================================================================");
	   WebElement nextPageLinkElemnt = firefoxDriver.findElement(By.className("next"));
       if(nextPageLinkElemnt.isEnabled()){

    	   nextPageLinkElemnt.click();
           Thread.sleep(5000);
           WebElement element4 = firefoxDriver.findElement(By.id("comment-0"));
           System.out.println("count:"+element4.getText());
           getAllComments(pageNumber+1,firefoxDriver);
       }else{
    	   return ;
       }
   }
}
