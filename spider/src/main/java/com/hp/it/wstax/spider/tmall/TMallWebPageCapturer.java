/**
 * 
 */
package com.hp.it.wstax.spider.tmall;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hp.it.wstax.spider.dao.ProductDao;
import com.hp.it.wstax.spider.exception.TMallWebCrawlerException;
import com.hp.it.wstax.spider.selenium.TMallDetailPageCrawler;
import com.hp.it.wstax.spider.tmall.impl.DellTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.FujitsuTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.HPTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.HPTMallPrinterCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.SamsungTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.TMallCanonPrinterCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.TMallFujitsuPrinterCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.TMallSonyPcCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.TMallThinkPadPrinterCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.ThinkPadTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.impl.ToshibaTMallCaptureImpl;
import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.Constants;

/**
 * Fetch web page and process the html parsing.
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public abstract class  TMallWebPageCapturer {
    
    
    public final static int TMALL_HP = 1;
    
    public final static int TMALL_DELL = 2;
    
    public final static int TMALL_THINKPAD = 3;
    
    public final static int TMALL_HP_PRINTER = 4;
    
    public final static int TMALL_SONY =5;
    
    public final static int TMALL_Toshiba = 6;
    
    public final static int TMALL_Fujitsu=7;
    
    public final static int TMALL_Samsung=8;
    
    public final static int TMALL_CANON_PRINTER = 12;
    
    public final static int TMALL_FUJITSU_PRINTER = 13;
    
    public final static int  TMALL_THINKPAD_PRINTER = 14;
    
    public final static String PRODUCT_FILE_NAME = "c:\\report\\products-" + new Date().getTime() + ".txt";
    
    private ProductDao productDao = new ProductDao();
    
    public static TMallWebPageCapturer getInctance(int category){
        if ( category == TMALL_HP ) {
            return new HPTMallCaptureImpl();
        } else if ( category == TMALL_DELL ) {
            return new DellTMallCaptureImpl();
        } else if ( category == TMALL_THINKPAD ) {
            return new ThinkPadTMallCaptureImpl();
        } else if ( category == TMALL_HP_PRINTER ) {
            return new HPTMallPrinterCaptureImpl();
        } else if ( category == TMALL_SONY ) {
        	return new TMallSonyPcCaptureImpl();
        } else if ( category == TMALL_Toshiba ) {
            return new ToshibaTMallCaptureImpl();
         }else if ( category == TMALL_Fujitsu ) {
            return new FujitsuTMallCaptureImpl();
         }else if ( category == TMALL_Samsung ) {
         	 return new SamsungTMallCaptureImpl();
         } else if ( category ==TMALL_CANON_PRINTER ) {
        	 return new TMallCanonPrinterCaptureImpl();
         } else if( category == TMALL_FUJITSU_PRINTER ) {
        	 return new TMallFujitsuPrinterCaptureImpl();
         }	else if( category == TMALL_THINKPAD_PRINTER ) {
        	 return new TMallThinkPadPrinterCaptureImpl();
         } else {
             return null;
         }
    }

    /**
     * HTMLUnit Implementation.
     * 
     * @param url
     * @return
     * @throws IOException
     * @throws MalformedURLException
     * @throws FailingHttpStatusCodeException
     */
    public HtmlPage loadPageByURL(String url)
            throws FailingHttpStatusCodeException, MalformedURLException,
            IOException {

        WebClient client = new WebClient(BrowserVersion.CHROME,
                Constants.DEFAULT_PROXY_HOST, Constants.DEFAULT_PROXY_PORT);
        HtmlPage contentPage = client.getPage(url);

        return contentPage;
    }
    
    public void fetchAllData( Integer categoryId, Integer vendorId) throws InterruptedException, IOException, ParseException{
        List<Product> products = findTmallHPStoreAllProductList();
        
        if(null != products && products.size() > 0){
            
            System.out.println("products:"+products);
            
            System.out.println("products size:"+products.size());
            FileUtils.write(new File(PRODUCT_FILE_NAME), "products size:"+products.size()+"\r\n",true);
        FileUtils.writeLines(new File(PRODUCT_FILE_NAME), products,true);
        FileUtils.write(new File(PRODUCT_FILE_NAME),new Date()+"***********************************************\r\n",true);
            for (Product product : products) {
                
                if(!product.getProductName().contains("套餐") && !product.getProductName().contains("差价") && !product.getProductName().contains("S3超值")){
                    getDataByOneProduct(product,  categoryId,  vendorId);
                }
            }
        }
    }
    
    private void getDataByOneProduct(Product product ,  Integer categoryId, Integer vendorId){
        
        FirefoxDriver firefoxDriver = null;
        
        try {
            TMallDetailPageCrawler crawler = new TMallDetailPageCrawler();
            
            Long id = productDao.save(product.getProductName(), product.getProductUrl(), null,  categoryId, vendorId);
            
            product.setProductId(id);
            
            firefoxDriver = crawler.fetchData(product);
        } catch (Exception e) {
            e.printStackTrace();
            
           // getDataByOneProduct(product);
            
        } finally {
            if(firefoxDriver != null){
                firefoxDriver.quit();
            }
        }
    }
    
    /**
     * 
     * @return
     */
    public List<Product> findTmallHPStoreAllProductList(){
        try {
            List<Product> products = new ArrayList<Product>();
            HtmlPage htmlPage = loadPageByURL(getURL());
            products.addAll(findAllProductsInOnePage(htmlPage));
            
            fillNextPageProducts(products,htmlPage);
                
            return products;
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
            System.out.println(e.getStatusCode());
            System.out.println(e.getStatusMessage());
            throw new TMallWebCrawlerException(e.getMessage(), e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new TMallWebCrawlerException(e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new TMallWebCrawlerException(e.getMessage(), e);
        }
    }
    
    protected abstract String getURL();
    /**
     * @param htmlPage
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws FailingHttpStatusCodeException 
     */
    private void fillNextPageProducts(List<Product> products, HtmlPage htmlPage) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        
        if(hasNextPage(htmlPage)){
            String nextPageUrl = getNextPageUrl(htmlPage);
            HtmlPage nextPage = loadPageByURL(nextPageUrl);
            products.addAll(findAllProductsInOnePage(nextPage));
            fillNextPageProducts(products, nextPage);
        }
    }
    /**
     * @param htmlPage
     * @return
     */
    private boolean hasNextPage(HtmlPage htmlPage) {
        return null!=getNextPageUrl(htmlPage);
    }

    private String getNextPageUrl(HtmlPage page){
        
        HtmlAnchor nextAnchor = page.getAnchorByText("下一页");
        
        if(isElementEnableStyle(nextAnchor)){
            return nextAnchor.getHrefAttribute();
        } else {
            return null;
        }
    }
    /**
     * @param nextAnchor
     * @return
     */
    private boolean isElementEnableStyle(HtmlAnchor nextAnchor) {
        return !"disable".equalsIgnoreCase(getElementClass(nextAnchor));
    }
    
    /**
     * @param htmlPage
     */
    private List<Product> findAllProductsInOnePage(HtmlPage htmlPage) {
        List<Product> products = new ArrayList<Product>();
        
        List<HtmlAnchor> anchors = htmlPage.getAnchors();
        
        for (HtmlAnchor htmlAnchor : anchors) {
            if("item-name".equalsIgnoreCase(getElementClass(htmlAnchor))){
                Product product = new Product(htmlAnchor.getHrefAttribute(),
                        htmlAnchor.asText());
                products.add(product);
            }
        }
        
        return products;
    }
    /**
     * @param dom
     * @return
     */
    private String getElementClass(DomElement dom) {
        return dom.getAttribute("class");
    }

}
