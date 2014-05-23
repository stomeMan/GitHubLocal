package com.hp.it.wstax.spider.selenium;

import java.io.IOException;
import java.text.ParseException;
import junit.framework.TestCase;


/**
 * 
 * @author <a href="mailto: zhe-jiang.he@hp.com">hezhe</a>
 * @desc Method for test
 */

public class TopProds_LenovoTest extends TestCase{
	public @interface Annotation {

	}
	protected static final String[] UrlsArray = new String[]{"http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4361530812.71.zqb5A1&id=18989245140&rn=ed5f04580df599299301151489e52d56",
																								"http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4361530812.69.P4wk4p&id=18347853276&rn=606d5724cafd193fa52c2aaa70b32701",
																								"http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4361530812.79.P4wk4p&id=16160306912&rn=606d5724cafd193fa52c2aaa70b32701",
																								"http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4361530812.84.P4wk4p&id=22432695559&rn=606d5724cafd193fa52c2aaa70b32701",
																								"http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4361530812.89.P4wk4p&id=18430333024&rn=606d5724cafd193fa52c2aaa70b32701"};
	//batch Method for junit for invoke the fetchData 
	public void testBachFetchData_() throws InterruptedException, IOException, ParseException {
		for(int i=0; i<UrlsArray.length; i++){
			TopProds_Lenovo.getSinglenInstance_Leno().fetchData(UrlsArray[i], ++i);
		}
		
	}
	
	//Method for junit for invoke the fechData single for url
	public void testSingFetchData_() throws InterruptedException, IOException, ParseException {
		TopProds_Lenovo.getSinglenInstance_Leno().fetchData(null,1);
	}
}
 