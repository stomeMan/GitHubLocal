/**
 * 
 */
package com.hp.it.wstax.spider.exception;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 16, 2013
 * @revision
 */
public class TMallWebCrawlerException extends RuntimeException {

    /**
     * 
     */
    public TMallWebCrawlerException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public TMallWebCrawlerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public TMallWebCrawlerException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public TMallWebCrawlerException(Throwable cause) {
        super(cause);
    }

}
