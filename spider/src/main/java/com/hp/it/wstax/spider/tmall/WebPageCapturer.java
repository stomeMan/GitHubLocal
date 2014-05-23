/**
 * 
 */
package com.hp.it.wstax.spider.tmall;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hp.it.wstax.spider.exception.TMallWebCrawlerException;
import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.Constants;

/**
 * Fetch web page and process the html parsing.
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public class WebPageCapturer {

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
    
    
    
    /**
     * 
     * @return
     */
    public List<Product> findTmallHPStoreAllProductList(){
        try {
            List<Product> products = new ArrayList<Product>();
            HtmlPage htmlPage = loadPageByURL(Constants.TMALL_HP_ALL_PRODUCT_PAGE_URL);
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
