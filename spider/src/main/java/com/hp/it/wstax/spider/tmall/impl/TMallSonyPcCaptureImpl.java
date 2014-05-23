/**
 * 
 */
package com.hp.it.wstax.spider.tmall.impl;

import com.hp.it.wstax.spider.tmall.TMallWebPageCapturer;
import com.hp.it.wstax.spider.util.Constants;

/**
 * 
 * @author hezhe
 *
 */
public class TMallSonyPcCaptureImpl extends TMallWebPageCapturer {

    /* (non-Javadoc)
     * @see com.hp.it.wstax.spider.tmall.WebPageCapturer#getURL()
     */
    @Override
    protected String getURL() {
        return Constants.TMALL_SONY_PRODUCT_CATEGORY_URL;
    }

}
