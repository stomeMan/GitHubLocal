/**
 * 
 */
package com.hp.it.wstax.spider.tmall;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hp.it.wstax.spider.tmall.model.Product;

import org.junit.Test;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 17, 2013
 * @revision
 */
public class WebPageCapturerTest {

    /**
     * Test method for {@link com.hp.it.wstax.spider.tmall.TMallWebPageCapturer#findTmallHPStoreAllProductList()}.
     */
   /* @Test
    public void testFindTmallHPStoreAllProductList() {
        
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_HP);
        
        List<Product> products = capturer.findTmallHPStoreAllProductList();
        
        for (Product product : products) {
            System.out.println("url:" + product.getProductUrl());
            System.out.println("name:"+product.getProductName());
        }
    }
    @Test
    public void test() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_HP);
        HtmlPage page = capturer.loadPageByURL("http://detail.tmall.com/item.htm?id=13619870679&rn=447a05d12a6cffde89d7d2c97f0f40cb");
        
        System.out.println(page.asXml());
    }*/
	
	public  Integer categoryId = new Integer(1);
	public  Integer vendorId   = null;
	
    @Test
    public void testFetchAllDataHP() throws InterruptedException, IOException, ParseException{
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_HP);
        //categoryId = 
        vendorId = new Integer(1);
        capturer.fetchAllData( categoryId,  vendorId);
    }
    @Test
    public void testFetchAllDataDELL() throws InterruptedException, IOException, ParseException{
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_DELL);
        //categoryId = 
        vendorId = new Integer(2);
        capturer.fetchAllData( categoryId,  vendorId);
    }
    
    @Test
    public void testFetchAllDataTHINKPAD() throws InterruptedException, IOException, ParseException{
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_THINKPAD);
        //categoryId = 
        vendorId = new Integer(3);
        capturer.fetchAllData( categoryId,  vendorId);
    }
    @Test
    public void testFetchAllDataPrinterHP() throws InterruptedException, IOException, ParseException{
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_HP_PRINTER);
       // categoryId = 
        vendorId = new Integer(1);
        capturer.fetchAllData( categoryId,  vendorId);
    }
    
    @Test
    public void testFetchAllDataToshiba() throws InterruptedException, IOException, ParseException{
    	// categoryId = 
        vendorId = new Integer(4);
        TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_Toshiba);
        capturer.fetchAllData(categoryId,  vendorId);
    }
    
    @Test
    public void testFetchAllDataFujitsu() throws InterruptedException, IOException, ParseException{
    	// categoryId = 
        vendorId = new Integer(5);
    	TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_Fujitsu);
        capturer.fetchAllData(categoryId,  vendorId);
    }
    
    @Test
    public void testFetchAllDataSamsung() throws InterruptedException, IOException, ParseException{
    	// categoryId = 
        vendorId = new Integer(6);
    	TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_Samsung);
        capturer.fetchAllData(categoryId,  vendorId);
    }
    
    @Test
    public void testFetchAllDataSony() throws InterruptedException, IOException, ParseException{
    	 TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_SONY);
    	// categoryId = 
         vendorId = new Integer(7);
    	 capturer.fetchAllData( categoryId,  vendorId);
    }
    
    @Test
    public void testFetchCanonPrinter() throws InterruptedException, IOException, ParseException{
    	TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_CANON_PRINTER);
    	categoryId = new Integer(6);
        vendorId = new Integer(10);
   	    capturer.fetchAllData( categoryId,  vendorId);
    }
    
    @Test
    public void testFetchFujitsuPrinter() throws InterruptedException, IOException, ParseException{
    	TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_FUJITSU_PRINTER);
    	categoryId = new Integer(6);
        vendorId = new Integer(5);
   	    capturer.fetchAllData( categoryId,  vendorId);
    }
    
    @Test
    public void testFetchThinkPadPrinter() throws InterruptedException, IOException, ParseException{
    	TMallWebPageCapturer capturer = TMallWebPageCapturer.getInctance(TMallWebPageCapturer.TMALL_THINKPAD_PRINTER);
    	categoryId = new Integer(6);
        vendorId = new Integer(3);
   	    capturer.fetchAllData( categoryId,  vendorId);
    }

}
