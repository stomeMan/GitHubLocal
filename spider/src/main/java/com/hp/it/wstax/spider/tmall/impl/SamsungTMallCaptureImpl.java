package com.hp.it.wstax.spider.tmall.impl;

import com.hp.it.wstax.spider.tmall.TMallWebPageCapturer;
import com.hp.it.wstax.spider.util.Constants;

public class SamsungTMallCaptureImpl extends TMallWebPageCapturer {

	@Override
	protected String getURL() {
		// TODO Auto-generated method stub
		return Constants.TMALL_SAMSUNG_PRODUCT_CATEGORY_URL;
	}

}
