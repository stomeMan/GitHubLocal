/**
 * 
 */
package com.hp.it.wstax.spider.tmall.impl;

import com.hp.it.wstax.spider.tmall.TMallWebPageCapturer;
import com.hp.it.wstax.spider.util.Constants;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 27, 2013
 * @revision
 */
public class HPTMallPrinterCaptureImpl extends TMallWebPageCapturer {

    /* (non-Javadoc)
     * @see com.hp.it.wstax.spider.tmall.TMallWebPageCapturer#getURL()
     */
    @Override
    protected String getURL() {
        return Constants.TMALL_HP_PRINTER_CATEGORY_URL;
    }

}
