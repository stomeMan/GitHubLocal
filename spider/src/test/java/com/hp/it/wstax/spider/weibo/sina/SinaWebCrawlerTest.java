/**
 * 
 */
package com.hp.it.wstax.spider.weibo.sina;

import java.io.IOException;

import org.junit.Test;

import com.hp.it.wstax.spider.util.HttpHelper;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Jan 9, 2014
 * @revision
 */
public class SinaWebCrawlerTest {
    
    @Test
    public void testGetSinaSearchPage() throws InterruptedException, IOException {
        SinaWebCrawler crawler = new SinaWebCrawler();
        crawler.login();
       // crawler.getSinaSearchPage("HP Envy");
       // crawler.getSinaSearchPage("HP EliteBook");
        //crawler.getSinaSearchPage("HP ProBook");
      //  crawler.getSinaSearchPage("HP Slate");
       // crawler.getSinaSearchPage("HP Omni");
       // crawler.getSinaSearchPage("HP TouchSmart");
      //  crawler.getSinaSearchPage("HP Officejet");
      //  crawler.getSinaSearchPage("HP LaserJet Pro");
        crawler.getSinaSearchPage("HP Deskjet");
    }

}
