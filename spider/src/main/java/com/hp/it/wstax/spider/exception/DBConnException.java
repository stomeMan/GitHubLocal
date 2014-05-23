/**
 * 
 */
package com.hp.it.wstax.spider.exception;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 23, 2013
 * @revision
 */
public class DBConnException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 5561916750178941291L;

    /**
     * 
     */
    public DBConnException() {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public DBConnException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public DBConnException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public DBConnException(Throwable cause) {
        super(cause);
    }

}
