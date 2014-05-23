/**
 * 
 */
package com.hp.it.wstax.spider.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public class HttpHelper {
    
    private final static int TIMEOUT_SECONDS = 60;
    
    /**
     * @return
     */
    public static FirefoxDriver fireFoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        String proxyIp = Constants.DEFAULT_PROXY_HOST;
        int proxyPort = 8080;
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "proxy.compaq.com");
        profile.setPreference("network.proxy.http_port", proxyPort);
        profile.setPreference("network.proxy.share_proxy_settings", true);
        profile.setPreference("network.proxy.no_proxies_on", "localhost, 127.0.0.1");
        profile.setPreference("general.useragent.override", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.72 Safari/537.36");
        FirefoxDriver firefoxDriver = new FirefoxDriver(profile);
        
        firefoxDriver.manage().timeouts().pageLoadTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        
        return firefoxDriver;
    }
    
   /* public static ChromeDriver chromeDriver() {
        
        ChromeDriver chromeDriver = new ChromeDriver(Capabilities)
        
        return null;
    }*/

}
