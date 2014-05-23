/**
 * 
 */
package com.hp.it.wstax.spider.selenium;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import com.hp.it.wstax.spider.tmall.model.Product;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 19, 2013
 * @revision
 */
public class TMallDetailPageCrawlerTest {

    /**
     * Test method for {@link com.hp.it.wstax.spider.selenium.TMallDetailPageCrawler#fetchData()}.
     * @throws InterruptedException 
     * @throws IOException 
     * @throws ParseException 
     */
    @Test
    public void testFetchData() throws InterruptedException, IOException, ParseException {
        TMallDetailPageCrawler crawler = new TMallDetailPageCrawler();
        
        Product product = new Product("http://detail.tmall.com/item.htm?id=15597999368&rn=53857837b5ccd5f68c45409728d5592b", "test");
        product.setProductId(2049L);
        crawler.fetchData(product);
    }

}
