package com.hp.it.wstax.spider.yixun;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hp.it.wstax.spider.exception.TMallWebCrawlerException;
import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.Constants;

public class YixunPageHtmlUnitCapturer {
	
	/**
     * Get all HP products in yixun
     * @author Steve (wei-peng.yang@hp.com)
     * @date Dec 19, 2013 7:28:58 PM
     * @return
     */
    public List<Product> findYixunHPProductList() {
    	List<Product> products = new ArrayList<Product>();
    	try {
			HtmlPage htmlPage = loadPageByURL(Constants.YIXUN_HP_ALL_PRODUCT_PAGE_URL);
			// Firstly, get all products in the first page
			products.addAll(findAllProductsInOneYixunPage(htmlPage));
			// then get other products in other pages 
			fillNextYixunPageProducts(products,htmlPage);
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
     * Get all HP products in one yixun page 
     * @author Steve (wei-peng.yang@hp.com)
     * @date Dec 19, 2013 7:42:23 PM
     * @param htmlPage
     * @return
     */
    private List<Product> findAllProductsInOneYixunPage(HtmlPage htmlPage) {
        List<Product> products = new ArrayList<Product>(); 
        List<HtmlAnchor> anchors = htmlPage.getAnchors();
        
        for (HtmlAnchor htmlAnchor : anchors) {
        	/* The product detail in Html
        	 <p class="mod_goods_tit">
        	 	<a href="http://item.yixun.com/item-776060.html" target="_blank" 
        	 		title="HP 惠普 HP246 - F3K34PA#AB2 14英寸笔记本（Pentium 2020M/14＂ HD BV/2G 1600DDR3 1DM/500G/ATI HD7450M 1G独显/FreeDos/DVDRW）" 
        	 		onclick="logStat.chkItem(1,776060, '203360', true)" lg="1010" pos="1" rg="2002_1_2" ytag="12001">
        	 		HP 惠普 HP246 - F3K34PA#AB2 14英寸笔记本（Pentium 2020M/14＂ HD BV/2G 1600DDR3 1DM/500G/ATI HD7450M 1G独显/FreeDos/DVDRW）
        	 	</a>
        	 </p>
        	 */
            if("mod_goods_tit".equalsIgnoreCase(getElementClass(htmlAnchor))){
            	Iterable<DomElement> childEles = htmlAnchor.getChildElements();
            	for(DomElement ele: childEles){
            		if(ele.getTagName() != null && ele.getTagName().equals("a")){
            			Product product = new Product(ele.getAttribute("href"), ele.asText());
                        products.add(product);
            		}
            	}
                
            }
        }
        
        return products;
    }
    
    /**
     * Get all products in next yixun page
     * @author Steve (wei-peng.yang@hp.com)
     * @date Dec 19, 2013 7:42:45 PM
     * @param products  products list which save the products found
     * @param htmlPage  the products page
     * @throws FailingHttpStatusCodeException
     * @throws MalformedURLException
     * @throws IOException
     */
    private void fillNextYixunPageProducts(List<Product> products, HtmlPage htmlPage) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        if(hasNextPage(htmlPage)){
            String nextPageUrl = getNextPageUrl(htmlPage);
            HtmlPage nextPage = loadPageByURL(nextPageUrl);
            products.addAll(findAllProductsInOneYixunPage(nextPage));
            fillNextYixunPageProducts(products, nextPage);
        }
    }
    
    /**
     * @param dom
     * @return
     */
    private String getElementClass(DomElement dom) {
        return dom.getAttribute("class");
    }
    
    /**
     * @param htmlPage
     * @return
     */
    private boolean hasNextPage(HtmlPage htmlPage) {
        return null != getNextPageUrl(htmlPage);
    }

    /**
     * @author Steve (wei-peng.yang@hp.com)
     * @date Dec 20, 2013 10:38:43 AM
     * @param page
     * @return
     */
    private String getNextPageUrl(HtmlPage page){
        HtmlAnchor nextAnchor = page.getAnchorByText(Constants.NEXT_PAGE_TEXT_YIXUN);
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
}
