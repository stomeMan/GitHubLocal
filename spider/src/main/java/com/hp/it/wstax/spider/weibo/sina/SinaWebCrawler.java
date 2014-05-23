/**
 * 
 */
package com.hp.it.wstax.spider.weibo.sina;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hp.it.wstax.spider.util.Constants;
import com.hp.it.wstax.spider.util.GlobalUtils;
import com.hp.it.wstax.spider.util.HttpHelper;
import com.hp.it.wstax.spider.weibo.sina.model.Weibo;
import com.opera.core.systems.OperaAtom;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Jan 8, 2014
 * @revision
 */
public class SinaWebCrawler {
    
    private Date timeStamp = new Date();
    
    private boolean loginFlag = false;
    
    
   
    
   private void addToDocument(String topic, String posterName, String content, String dateStr,
           String faceURL, String userHomePageURL) throws UnsupportedEncodingException, IOException{
        
             String record =  GlobalUtils.formatXML(new Weibo(posterName, content, dateStr, faceURL,
                        userHomePageURL).toElement());
             
             FileUtils.write(new File("c:\\report\\weibo_com"+URLEncoder.encode(topic,"UTF-8")+timeStamp.getTime()+".xml"), record+"\r\n\r\n",true);
        
        
   }
   
   public void createDocument(String topic) throws UnsupportedEncodingException, IOException{
       FileUtils.write(new File("c:\\report\\weibo_com"+URLEncoder.encode(topic,"UTF-8")+timeStamp.getTime()+".xml"), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<records>",true);
   }
   
   public void endDocument(String topic) throws UnsupportedEncodingException, IOException{
       FileUtils.write(new File("c:\\report\\weibo_com"+URLEncoder.encode(topic,"UTF-8")+timeStamp.getTime()+".xml"), "\r\n</records>",true);
   }
    
    private boolean isLogin(){
        return loginFlag;
    }
    
    private FirefoxDriver firefoxDriver;
    
    
    /**
     * @param firefoxDriver the firefoxDriver to set
     */
    private void setFirefoxDriver(FirefoxDriver firefoxDriver) {
        this.firefoxDriver = firefoxDriver;
    }

    public void getSinaSearchPage(String topic) throws InterruptedException, IOException{
        System.out.println("is login?:"+loginFlag);
        if(!isLogin()){
            login();
            Thread.sleep(5000);
        }
       
//       firefoxDriver.navigate().
       
       String encodeTopic = URLEncoder.encode(topic, "UTF-8");
       String url = Constants.SINA_WEIBO_SEARCH.replace("<keywords>", encodeTopic);
       try {
        firefoxDriver.get(url);
    } catch (Exception e) {
        e.printStackTrace();
    }
       Thread.sleep(5000);
       
       createDocument(topic);
       loadRecordsOnOnePage(topic);
       endDocument(topic);
       
       System.out.println("finished");
      // quit();
    }

    /**
     * 
     */
    public void quit() {
        firefoxDriver.quit();
           firefoxDriver = null;
           loginFlag = false;
    }

    /**
     * @param firefoxDriver
     * @throws IOException 
     */
    public void loadRecordsOnOnePage(String topic) throws IOException {
        List<WebElement> searchFeedElements = firefoxDriver.findElementsByClassName("search_feed");
           
           List<WebElement> weiboRecords = searchFeedElements.get(searchFeedElements.size()-1).findElements(By.tagName("dl"));
           System.out.println(weiboRecords.size());
           for (WebElement weiboRecord : weiboRecords) {
               System.out.println("action type:"+weiboRecord.getAttribute("action-type"));
               
               if("feed_list_item".equals(weiboRecord.getAttribute("action-type"))){
               
                   WebElement faceImgElement = weiboRecord.findElement(By.className("face")).findElement(By.tagName("img"));
                   
                   WebElement contentElement = weiboRecord.findElement(By.className("content"));
                   
                   WebElement posterNameElement= contentElement.findElements(By.tagName("a")).get(0);
                   
                   WebElement postDateElement = contentElement.findElement(By.className("info")).findElement(By.className("date"));
                   
                   WebElement contentTextElement = contentElement.findElement(By.tagName("em"));
                   
                   addToDocument(topic,posterNameElement.getText(),contentTextElement.getText(),postDateElement.getText(),faceImgElement.getAttribute("src"),posterNameElement.getAttribute("href"));
                   
                System.out.println(contentTextElement.getText());
                
               // FileUtils.write(new File("c:\\report\\weibo_com"+URLEncoder.encode(topic,"UTF-8")+timeStamp.getTime()+".txt"), contentTextElement.getText()+"\r\n\r\n",true);
               }
                 
                
           }
           WebElement pageBox = firefoxDriver.findElementByClassName("search_page_M");
           
           try {
            WebElement nextPageLink = pageBox.findElement(By.linkText("下一页"));
            try {
                nextPageLink.click();
            } catch (Exception e) {
//                firefoxDriver.
                System.out.println("next page loding to long.");
                e.printStackTrace();
            }
            
            Thread.sleep(3000);
            loadRecordsOnOnePage(topic);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           
    }

    /**
     * @param driver
     * @throws InterruptedException
     */
    public void login() throws InterruptedException {
        
        FirefoxDriver driver = HttpHelper.fireFoxDriver();
        setFirefoxDriver(driver);
        try {
            driver.get("http://www.weibo.com");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
       Thread.sleep(5000);
       System.out.println(driver.getPageSource());
       WebElement userNameInput =  driver.findElementByName("username");
       System.out.println("user name:"+userNameInput.getTagName());
       System.out.println("user name:"+userNameInput.isDisplayed());
       System.out.println("user name:"+userNameInput.isEnabled());
       System.out.println("user name:"+userNameInput.getCssValue("display"));
       System.out.println("user name:"+userNameInput.getCssValue("visibility"));
       System.out.println("user name:"+userNameInput.getCssValue("opacity"));
       System.out.println("user name:"+userNameInput.getCssValue("height"));
       System.out.println("user name:"+userNameInput.getCssValue("width"));
       System.out.println("user name:"+userNameInput.getAttribute("type"));
       System.out.println(OperaAtom.IS_DISPLAYED);
       ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", userNameInput);
       userNameInput.clear();
       userNameInput.sendKeys("jupiter_bigdata@163.com");
       
       WebElement passwordInput = driver.findElementByName("password");
       passwordInput.clear();
       passwordInput.sendKeys("zaq12wsx");
       
       /*List<WebElement> spans = firefoxDriver.findElementsByTagName("span");
       
       for (WebElement span : spans) {
           if(span.getText().equals("登陆")){
               span.click();
           }
       }*/
       
       WebElement submitBtn = driver.findElementByClassName("W_btn_g");
       
       try {
        submitBtn.click();
    } catch (Exception e1) {
        e1.printStackTrace();
    }
       
       Thread.sleep(5000);
       
       try {
           inputVerifyCode();
           
           submitBtn.click();
    } catch (Exception e) {
        e.printStackTrace();
    }
       
       loginFlag = true;
       
    }

    /**
     * @param driver
     */
    private void inputVerifyCode() {
        WebElement verifiedCode = firefoxDriver.findElementByName("verifycode");
           
           verifiedCode.clear();
           
           Scanner cin = new Scanner(System.in);
           
           System.out.println("Please input verify code:");
           
           String codeStr = cin.nextLine();
           
           verifiedCode.sendKeys(codeStr);
    }
    
    /*public static void main(String[] args) throws InterruptedException {
        SinaWebCrawler crawler = new SinaWebCrawler();
        crawler.getSinaSearchPage();
    }*/


}
