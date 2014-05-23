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
 * @date Dec 23, 2013
 * @revision
 */
public class ThinkPadTMallCaptureImpl extends TMallWebPageCapturer {

    /* (non-Javadoc)
     * @see com.hp.it.wstax.spider.tmall.WebPageCapturer#getURL()
     */
    @Override
    protected String getURL() {
        return Constants.TMALL_THINKPAD_PRODUCT_CATEGORY_URL;
    }

}
