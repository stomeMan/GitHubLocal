/**
 * 
 */
package com.hp.it.wstax.spider.weibo.sina.model;

import java.io.IOException;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.BaseElement;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date 2014-1-15
 * @revision
 */
public class Weibo {
    
    private String posterName;
    
    private String content;
    
    private String dateStr;
    
    private String faceURL;
    
    private String userHomePageURL;
    
    /**
     * 
     */
    public Weibo() {
        // TODO Auto-generated constructor stub
    }
    
    

    /**
     * @param posterName
     * @param content
     * @param dateStr
     * @param faceURL
     * @param userHomePageURL
     */
    public Weibo(String posterName, String content, String dateStr,
            String faceURL, String userHomePageURL) {
        super();
        this.posterName = posterName;
        this.content = content;
        this.dateStr = dateStr;
        this.faceURL = faceURL;
        this.userHomePageURL = userHomePageURL;
    }



    /**
     * @return the faceURL
     */
    public String getFaceURL() {
        return faceURL;
    }



    /**
     * @param faceURL the faceURL to set
     */
    public void setFaceURL(String faceURL) {
        this.faceURL = faceURL;
    }



    /**
     * @return the userHomePageURL
     */
    public String getUserHomePageURL() {
        return userHomePageURL;
    }



    /**
     * @param userHomePageURL the userHomePageURL to set
     */
    public void setUserHomePageURL(String userHomePageURL) {
        this.userHomePageURL = userHomePageURL;
    }



    /**
     * @return the posterName
     */
    public String getPosterName() {
        return posterName;
    }

    /**
     * @param posterName the posterName to set
     */
    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the dateStr
     */
    public String getDateStr() {
        return dateStr;
    }

    /**
     * @param dateStr the dateStr to set
     */
    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
    
    public Element toElement(){
        
        Element parentElement = new BaseElement("weibo_record");
        Element posterName = new BaseElement("poster_name");
        Element content = new BaseElement("content");
        Element faceURL = new BaseElement("face_url");
        Element homePageUrl = new BaseElement("home_page_url");
        Element dateStr = new BaseElement("post_date");
        
        posterName.addText(getPosterName());
        content.addText(getContent());
        faceURL.addText(getFaceURL());
        homePageUrl.addText(getUserHomePageURL());
        dateStr.addText(getDateStr());
        
        parentElement.add(posterName);
        parentElement.add(content);
        parentElement.add(faceURL);
        parentElement.add(homePageUrl);
        parentElement.add(dateStr);
        
        
        
        return parentElement;
    }
    
    
    
    public static void main(String[] args) {
        Document document = DocumentFactory.getInstance().createDocument(new BaseElement("records"));
        
        document.getRootElement().add(new Weibo("test user", "testtesttest", "1900 02 03", "http://www.weibo.com", "http://www.home.com").toElement());
        
        System.out.println(document.asXML());
    }

   

    
    

}
