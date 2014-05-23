package com.hp.it.wstax.spider.selenium;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hp.it.wstax.spider.tmall.model.Product;
import com.hp.it.wstax.spider.util.Constants;

public class YixunProductsPageCapturer {
//	private static Logger logger = Logger.getLogger(YixunProductsPageCapturer.class);
	public static final String HTML_TAG_P_CLASS_NAME = "mod_goods_tit";
	public static final String HTML_TAG_A_NAME = "a";
	public static final String HTML_TAG_A_HREF_NAME = "href";
	public static int pageCount = 0;
	
	/**
	 * Get all HP products, include: desktop, laptop, printer...
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 20, 2013 1:40:28 PM
	 * @return the list of product
	 */
	public List<Product> findAllHPProducts(){
		List<Product> products = new ArrayList<Product>();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(Constants.YIXUN_HP_ALL_PRODUCT_PAGE_URL);
//		logger.debug("Start Capture page: " + Constants.YIXUN_HP_ALL_PRODUCT_PAGE_URL);
		
		pageCount ++;
		// Firstly, we get the products from the first page
		products.addAll(findAllHPProductsFromOnePage(driver));
		// Then get products from next page...
		findAllHPProductsFromNextPage(products, driver);
		
		//driver.quit();
		driver.close(); // You MUST close the driver
		return products;
	}
	
	/**
	 * Get all of the products from one page 
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 20, 2013 1:41:29 PM
	 * @param firefoxDriver
	 * @return
	 */
	public List<Product> findAllHPProductsFromOnePage(FirefoxDriver firefoxDriver){
		scrollPageDown(firefoxDriver);
//		logger.debug("Scroll page down to load all page content.");
		List<Product> productList = new ArrayList<Product>();
		// Get all of the <P> element in the page
//		List<WebElement> peleList = firefoxDriver.findElements(By.className(HTML_TAG_P_CLASS_NAME));
//		if(CollectionUtils.isNotEmpty(peleList)){
//			for(WebElement pele: peleList){
//				// Get the first <a> element in <P>, then get product info
//				WebElement aele = pele.findElement(By.tagName(HTML_TAG_A_NAME));
//				if(aele != null){
//					Product product = new Product(aele.getAttribute(HTML_TAG_A_HREF_NAME), aele.getText());
//					productList.add(product);
//				}
//			}
//		}
		return productList;
	}
	
	/**
	 * Get all HP producs from next page, and next next page by recursion... 
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 20, 2013 1:41:51 PM
	 * @param productList
	 * @param firefoxDriver
	 */
	public void findAllHPProductsFromNextPage(List<Product> productList, FirefoxDriver firefoxDriver){
		String nextPageUrl = getNextPageUrl(firefoxDriver);
		if(!StringUtils.isBlank(nextPageUrl)){
			pageCount ++;
			firefoxDriver.get(nextPageUrl);
//			logger.debug("Start Capture page: " + nextPageUrl);
			productList.addAll(findAllHPProductsFromOnePage(firefoxDriver));
			findAllHPProductsFromNextPage(productList, firefoxDriver);
		}
	}
	
	/**
	 * Get next page's URL from the current page
	 * Note: 有时候会出问题
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 20, 2013 1:43:06 PM
	 * @param firefoxDriver
	 * @return
	 */
	public String getNextPageUrl(FirefoxDriver firefoxDriver){
		String nextPageUrl = null;
		String nextPageAClass = "sort_page_arrow";
		WebElement ele = firefoxDriver.findElement(By.className(nextPageAClass));
		if(ele != null){
			String title = ele.getAttribute("title");
			if(!StringUtils.isBlank(title) && title.equals("下一页")){
				nextPageUrl = ele.getAttribute(HTML_TAG_A_HREF_NAME);
			}
		}
		return nextPageUrl;
	}
	
	public List<String> getAllPageUrlsByPageIndex(FirefoxDriver firefoxDriver){
		List<String> pageUrls = new ArrayList<String>();
		String currentPage = firefoxDriver.getCurrentUrl();
		
		return pageUrls;
	}
	
	//
	private boolean hasNextPage(FirefoxDriver firefoxDriver){
		return null != getNextPageUrl(firefoxDriver);
	}
	
	
	/**
	 * Scroll down to load all page
	 * @author Steve (wei-peng.yang@hp.com)
	 * @date Dec 20, 2013 11:07:10 AM
	 * @param firefoxDriver
	 */
	private void scrollPageDown(FirefoxDriver firefoxDriver){
		for (int i = 0; i < 10; i++) {
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// DO Nothing
			}
        }
	}

}
