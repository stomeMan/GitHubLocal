/**
 * 
 */
package com.hp.it.wstax.spider.util;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public class ProxyServer {
    
    private String proxyHost;
    
    private String proxyPort;
    
    private boolean proxyEnable = false;
    
    private String proxyUserName;
    
    private String proxyPassword;
    
    
    /**
     * 
     */
    public ProxyServer() {
        setProxyEnable(false);
    }

    /**
     * @param proxyHost
     * @param proxyPort
     */
    public ProxyServer(String proxyHost, String proxyPort) {
        super();
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        setProxyEnable(true);
    }
    
    

    /**
     * @param proxyHost
     * @param proxyPort
     * @param proxyUserName
     * @param proxyPassword
     */
    public ProxyServer(String proxyHost, String proxyPort,
            String proxyUserName, String proxyPassword) {
        super();
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.proxyUserName = proxyUserName;
        this.proxyPassword = proxyPassword;
        setProxyEnable(true);
    }



    /**
     * @return the proxyHost
     */
    public String getProxyHost() {
        return proxyHost;
    }

    /**
     * @param proxyHost the proxyHost to set
     */
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    /**
     * @return the proxyPort
     */
    public String getProxyPort() {
        return proxyPort;
    }

    /**
     * @param proxyPort the proxyPort to set
     */
    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    /**
     * @return the proxyEnable
     */
    public boolean isProxyEnable() {
        return proxyEnable;
    }

    /**
     * @param proxyEnable the proxyEnable to set
     */
    public void setProxyEnable(boolean proxyEnable) {
        this.proxyEnable = proxyEnable;
    }

    /**
     * @return the proxyUserName
     */
    public String getProxyUserName() {
        return proxyUserName;
    }

    /**
     * @param proxyUserName the proxyUserName to set
     */
    public void setProxyUserName(String proxyUserName) {
        this.proxyUserName = proxyUserName;
    }

    /**
     * @return the proxyPassword
     */
    public String getProxyPassword() {
        return proxyPassword;
    }

    /**
     * @param proxyPassword the proxyPassword to set
     */
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }
    
    
    

}
