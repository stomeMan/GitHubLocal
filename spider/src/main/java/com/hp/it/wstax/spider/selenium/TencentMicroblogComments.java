/**
 * 
 */
package com.hp.it.wstax.spider.selenium;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;

import com.hp.it.wstax.spider.tmall.model.DealRecord;
import com.hp.it.wstax.spider.util.DateFormatter;
import com.hp.it.wstax.spider.util.HttpHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 19, 2013
 * @revision
 */
public class TencentMicroblogComments {
    
//    private String RATE_FILE_NAME = "c:\\report\\HpHrInfo";
    private String RATE_FILE_NAME = "c:\\report\\";
    
    private String DEAL_FILE_NAME = "C:\\report\\dealrecord"+new Date().getTime()+".txt";
    private String[] fromTimeArr={"2014年01月07日&s_dup=1&p=1","2014年01月17日&s_dup=1&p=1","2014年01月27日"};
    private String[] toTimeArr={"2014年1月0日16&s_dup=1&p=1","2014年01月26日&s_dup=1&p=1","2013年02月06日"};
    
    private static String [] name={/**"1176113560@qq.com","624757102@qq.com", "2769109083qq.com","2784217606@qq.com","2069524797@qq.com","1216189104@qq.com","850984363@qq.com","2106019406","2293606308","2110315654","2963319438", "2955054306", "1796457651",**/"2116753500","2839167826", "1805981720", "2012326459" ," 2945815490", "2840750344",
"123456789"};
    private static String [] password={/**"159xl,.!123456","ghl,.880501", "159xl,.!12345"   ,"159xl,.!1234567"  ,   "159xl,.!12345678","123456789","ghl,.880501" ,"159xl,.!12345678","159xl,.!12345678","159xl,.!12345678"123456789","123456789","123456789","**/"123456789","123456789","123456789","123456789","123456789","123456789"};
    private static String loginUrl="http://ui.ptlogin2.qq.com/cgi-bin/login?appid=46000101&style=13&lang=&low_login=1&hide_title_bar=1&hide_close_icon=1&self_regurl=http%3A//reg.t.qq.com/index.php&s_url=http%3A%2F%2Ft.qq.com&daid=6";
    
    private  int i=0;
    private int j=0;
    private static String [] urls={
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140424%2C20140424&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140423%2C20140423&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140422%2C20140422&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140421%2C20140421&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140420%2C20140420&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140419%2C20140419&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140418%2C20140418&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140417%2C20140417&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140416%2C20140416&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140415%2C20140415&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140414%2C20140414&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140413%2C20140413&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140412%2C20140412&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140411%2C20140411&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140410%2C20140410&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140409%2C20140409&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140408%2C20140408&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140407%2C20140407&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140406%2C20140406&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140405%2C20140405&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140404%2C20140404&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140403%2C20140403&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140402%2C20140402&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140401%2C20140401&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140331%2C20140331&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140330%2C20140330&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140329%2C20140329&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140328%2C20140328&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140327%2C20140327&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140326%2C20140326&s_dup=1&p=1",
//								server is down     	搜太多啦，服务器累得回火星了，休息一下吧！
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140325%2C20140325&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140324%2C20140324&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140323%2C20140323&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140322%2C20140322&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140321%2C20140321&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140320%2C20140320&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140319%2C20140319&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140318%2C20140318&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140317%2C20140317&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140316%2C20140316&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140315%2C20140315&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140314%2C20140314&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140313%2C20140313&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140312%2C20140312&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140311%2C20140311&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140310%2C20140310&s_dup=1&p=1",
			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140309%2C20140309&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140308%2C20140308&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140307%2C20140307&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140306%2C20140306&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140305%2C20140305&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140304%2C20140304&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140303%2C20140303&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140302%2C20140302&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140309%2C20140301&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140229%2C20140229&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140228%2C20140228&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140227%2C20140227&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140226%2C20140226&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140225%2C20140225&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140224%2C20140224&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140223%2C20140223&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140222%2C20140222&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140221%2C20140221&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140220%2C20140220&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140219%2C20140219&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140218%2C20140218&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140217%2C20140217&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140216%2C20140216&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140215%2C20140215&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140214%2C20140214&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140213%2C20140213&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140212%2C20140212&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140211%2C20140211&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140210%2C20140210&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140209%2C20140209&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140208%2C20140208&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140207%2C20140207&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140206%2C20140206&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140205%2C20140205&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140204%2C20140204&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140203%2C20140203&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140202%2C20140202&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140201%2C20140201&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140131%2C20140131&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140130%2C20140130&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140129%2C20140129&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140128%2C20140128&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140127%2C20140127&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140126%2C20140126&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140125%2C20140125&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140124%2C20140124&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140123%2C20140123&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140122%2C20140122&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140121%2C20140121&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140120%2C20140120&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140119%2C20140119&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140118%2C20140118&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140117%2C20140117&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140116%2C20140116&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140115%2C20140115&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140114%2C20140114&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140113%2C20140113&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140112%2C20140112&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140111%2C20140111&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140110%2C20140110&s_dup=1&p=1",
//			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140109%2C20140109&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140108%2C20140108&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140107%2C20140107&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140106%2C20140106&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140105%2C20140105&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140104%2C20140104&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140103%2C20140103&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140102%2C20140102&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140101%2C20140101&s_dup=1&p=1",
//		************************************************2014 end*************************************************************************
			
			
//		************************************************2013 begin*************************************************************************
//														Dec
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131231%2C20130731&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131230%2C20131230&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131229%2C20131229&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131228%2C20131228&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131227%2C20131227&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131226%2C20131226&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131225%2C20131225&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131224%2C20131224&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131223%2C20131223&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131222%2C20131222&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131221%2C20131221&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131220%2C20131220&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131219%2C20131219&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131218%2C20131218&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131217%2C20131217&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131216%2C20131216&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131215%2C20131215&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131214%2C20131214&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131213%2C20131213&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131212%2C20131212&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131211%2C20131211&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131210%2C20131210&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131209%2C20131209&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131208%2C20131208&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131207%2C20131207&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131206%2C20131206&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131205%2C20131205&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131204%2C20131204&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131203%2C20131203&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131202%2C20131202&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131209%2C20131201&s_dup=1&p=1",
////														Nov
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131130%2C20131130&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131129%2C20131129&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131128%2C20131128&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131127%2C20131127&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131126%2C20131126&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131125%2C20131125&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131124%2C20131124&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131123%2C20131123&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131122%2C20131122&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131121%2C20131121&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131120%2C20131120&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131119%2C20131119&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131118%2C20131118&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131117%2C20131117&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131116%2C20131116&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131115%2C20131115&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131114%2C20131114&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131113%2C20131113&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131112%2C20131112&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131111%2C20131111&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131110%2C20131110&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131109%2C20131109&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131108%2C20131108&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131107%2C20131107&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131106%2C20131106&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131105%2C20131105&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131104%2C20131104&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131103%2C20131103&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131102%2C20131102&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131101%2C20131101&s_dup=1&p=1",
////														Oct
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131031%2C20131031&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131030%2C20131030&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131029%2C20131029&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131028%2C20131028&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131027%2C20131027&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131026%2C20131026&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131025%2C20131025&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131024%2C20131024&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131023%2C20131023&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131022%2C20131022&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131021%2C20131021&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131020%2C20131020&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131019%2C20131019&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131018%2C20131018&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131017%2C20131017&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131016%2C20131016&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131015%2C20131015&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131014%2C20131014&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131013%2C20131013&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131012%2C20131012&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131011%2C20131011&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131010%2C20131010&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131009%2C20131009&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131008%2C20131008&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131007%2C20131007&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131006%2C20131006&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131005%2C20131005&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131004%2C20131004&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131003%2C20131003&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131002%2C20131002&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131009%2C20131001&s_dup=1&p=1",
////														Sep
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130930%2C20130930&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130929%2C20130929&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130928%2C20130928&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130927%2C20130927&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130926%2C20130926&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130925%2C20130925&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130924%2C20130924&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130923%2C20130923&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130922%2C20130922&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130921%2C20130921&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130920%2C20130920&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130919%2C20130919&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130918%2C20130918&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130917%2C20130917&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130916%2C20130916&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130915%2C20130915&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130914%2C20130914&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130913%2C20130913&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130912%2C20130912&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130911%2C20130911&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130910%2C20130910&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130909%2C20130909&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130908%2C20130908&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130907%2C20130907&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130906%2C20130906&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130905%2C20130905&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130904%2C20130904&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130903%2C20130903&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130902%2C20130902&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130901%2C20130901&s_dup=1&p=1",
////														Aug			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130831%2C20130831&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130830%2C20130830&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130829%2C20130829&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130828%2C20130828&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130827%2C20130827&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130826%2C20130826&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130825%2C20130825&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130824%2C20130824&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130823%2C20130823&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130822%2C20130822&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130821%2C20130821&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130820%2C20130820&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130819%2C20130819&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130818%2C20130818&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130817%2C20130817&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130816%2C20130816&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130815%2C20130815&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130814%2C20130814&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130813%2C20130813&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130812%2C20130812&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130811%2C20130811&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130810%2C20130810&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130809%2C20130809&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130808%2C20130808&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130807%2C20130807&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130806%2C20130806&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130805%2C20130805&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130804%2C20130804&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130803%2C20130803&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130802%2C20130802&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130801%2C20130801&s_dup=1&p=1",
//														JUl
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20131231%2C20130731&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130730%2C20130730&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130729%2C20130729&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130728%2C20130728&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130727%2C20130727&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130726%2C20130726&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130725%2C20130725&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130724%2C20130724&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130723%2C20130723&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130722%2C20130722&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130721%2C20130721&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130720%2C20130720&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130719%2C20130719&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130718%2C20130718&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130717%2C20130717&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130716%2C20130716&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130715%2C20130715&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130714%2C20130714&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130713%2C20130713&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130712%2C20130712&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130711%2C20130711&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130710%2C20130710&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130709%2C20130709&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130708%2C20130708&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130707%2C20130707&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130706%2C20130706&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130705%2C20130705&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130704%2C20130704&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130703%2C20130703&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130702%2C20130702&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130709%2C20130701&s_dup=1&p=1",
////														Jun
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130630%2C20130630&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130629%2C20130629&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130628%2C20130628&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130627%2C20130627&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130626%2C20130626&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130625%2C20130625&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130624%2C20130624&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130623%2C20130623&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130622%2C20130622&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130621%2C20130621&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130620%2C20130620&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130619%2C20130619&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130618%2C20130618&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130617%2C20130617&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130616%2C20130616&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130615%2C20130615&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130614%2C20130614&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130613%2C20130613&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130612%2C20130612&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130611%2C20130611&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130610%2C20130610&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130609%2C20130609&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130608%2C20130608&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130607%2C20130607&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130606%2C20130606&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130605%2C20130605&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130604%2C20130604&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130603%2C20130603&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130602%2C20130602&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130601%2C20130601&s_dup=1&p=1",
//			
////														May
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130531%2C20130531&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130530%2C20130530&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130529%2C20130529&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130528%2C20130528&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130527%2C20130527&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130526%2C20130526&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130525%2C20130525&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130524%2C20130524&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130523%2C20130523&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130522%2C20130522&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130521%2C20130521&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130520%2C20130520&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130519%2C20130519&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130518%2C20130518&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130517%2C20130517&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130516%2C20130516&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130515%2C20130515&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130514%2C20130514&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130513%2C20130513&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130512%2C20130512&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130511%2C20130511&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130510%2C20130510&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130509%2C20130509&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130508%2C20130508&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130507%2C20130507&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130506%2C20130506&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130505%2C20130505&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130504%2C20130504&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130503%2C20130503&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130502%2C20130502&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130509%2C20130501&s_dup=1&p=1",
////														Apr
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130430%2C20130430&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130429%2C20130429&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130428%2C20130428&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130427%2C20130427&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130426%2C20130426&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130425%2C20130425&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130424%2C20130424&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130423%2C20130423&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130422%2C20130422&s_dup=1&p=1",
//    		"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130421%2C20130421&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130420%2C20130420&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130419%2C20130419&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130418%2C20130418&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130417%2C20130417&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130416%2C20130416&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130415%2C20130415&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130414%2C20130414&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130413%2C20130413&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130412%2C20130412&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130411%2C20130411&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130410%2C20130410&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130409%2C20130409&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130408%2C20130408&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130407%2C20130407&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130406%2C20130406&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130405%2C20130405&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130404%2C20130404&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130403%2C20130403&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130402%2C20130402&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130401%2C20130401&s_dup=1&p=1",
////													Mar
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130331%2C20130331&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130330%2C20130330&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130329%2C20130329&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130328%2C20130328&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130327%2C20130327&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130326%2C20130326&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130325%2C20130325&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130324%2C20130324&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130323%2C20130323&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130322%2C20130322&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130321%2C20130321&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130320%2C20130320&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130319%2C20130319&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130318%2C20130318&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130317%2C20130317&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130316%2C20130316&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130315%2C20130315&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130314%2C20130314&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130313%2C20130313&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130312%2C20130312&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130311%2C20130311&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130310%2C20130310&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130309%2C20130309&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130308%2C20130308&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130307%2C20130307&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130306%2C20130306&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130305%2C20130305&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130304%2C20130304&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130303%2C20130303&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130302%2C20130302&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130309%2C20130301&s_dup=1&p=1",
////			                                      Feb
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130229%2C20130229&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130228%2C20130228&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130227%2C20130227&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130226%2C20130226&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130225%2C20130225&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130224%2C20130224&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130223%2C20130223&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130222%2C20130222&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130221%2C20130221&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130220%2C20130220&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130219%2C20130219&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130218%2C20130218&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130217%2C20130217&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130216%2C20130216&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130215%2C20130215&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130214%2C20130214&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130213%2C20130213&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130212%2C20130212&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130211%2C20130211&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130210%2C20130210&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130209%2C20130209&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130208%2C20130208&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130207%2C20130207&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130206%2C20130206&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130205%2C20130205&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130204%2C20130204&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130203%2C20130203&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130202%2C20130202&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130201%2C20130201&s_dup=1&p=1",
//													Jan
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130131%2C20130131&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130130%2C20130130&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130129%2C20130129&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130128%2C20130128&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130127%2C20130127&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130126%2C20130126&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130125%2C20130125&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130124%2C20130124&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130123%2C20130123&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130122%2C20130122&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130121%2C20130121&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130120%2C20130120&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130119%2C20130119&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130118%2C20130118&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130117%2C20130117&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130116%2C20130116&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130115%2C20130115&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130114%2C20130114&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130113%2C20130113&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130112%2C20130112&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130111%2C20130111&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130110%2C20130110&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130109%2C20130109&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130108%2C20130108&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130107%2C20130107&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130106%2C20130106&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130105%2C20130105&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130104%2C20130104&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130103%2C20130103&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130102%2C20130102&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20130101%2C20130101&s_dup=1&p=1",
//		************************************************2013 end*************************************************************************
			
//		************************************************2012 begin***********************************************************************
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121231%2C20120731&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121230%2C20121230&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121229%2C20121229&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121228%2C20121228&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121227%2C20121227&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121226%2C20121226&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121225%2C20121225&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121224%2C20121224&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121223%2C20121223&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121222%2C20121222&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121221%2C20121221&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121220%2C20121220&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121219%2C20121219&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121218%2C20121218&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121217%2C20121217&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121216%2C20121216&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121215%2C20121215&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121214%2C20121214&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121213%2C20121213&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121212%2C20121212&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121211%2C20121211&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121210%2C20121210&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121209%2C20121209&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121208%2C20121208&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121207%2C20121207&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121206%2C20121206&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121205%2C20121205&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121204%2C20121204&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121203%2C20121203&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121202%2C20121202&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121209%2C20121201&s_dup=1&p=1",
////						Nov
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121130%2C20121130&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121129%2C20121129&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121128%2C20121128&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121127%2C20121127&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121126%2C20121126&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121125%2C20121125&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121124%2C20121124&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121123%2C20121123&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121122%2C20121122&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121121%2C20121121&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121120%2C20121120&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121119%2C20121119&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121118%2C20121118&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121117%2C20121117&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121116%2C20121116&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121115%2C20121115&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121114%2C20121114&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121113%2C20121113&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121112%2C20121112&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121111%2C20121111&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121110%2C20121110&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121109%2C20121109&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121108%2C20121108&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121107%2C20121107&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121106%2C20121106&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121105%2C20121105&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121104%2C20121104&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121103%2C20121103&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121102%2C20121102&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121101%2C20121101&s_dup=1&p=1",
////						Oct
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121031%2C20121031&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121030%2C20121030&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121029%2C20121029&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121028%2C20121028&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121027%2C20121027&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121026%2C20121026&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121025%2C20121025&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121024%2C20121024&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121023%2C20121023&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121022%2C20121022&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121021%2C20121021&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121020%2C20121020&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121019%2C20121019&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121018%2C20121018&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121017%2C20121017&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121016%2C20121016&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121015%2C20121015&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121014%2C20121014&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121013%2C20121013&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121012%2C20121012&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121011%2C20121011&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121010%2C20121010&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121009%2C20121009&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121008%2C20121008&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121007%2C20121007&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121006%2C20121006&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121005%2C20121005&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121004%2C20121004&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121003%2C20121003&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121002%2C20121002&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121009%2C20121001&s_dup=1&p=1",
////						Sep
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120930%2C20120930&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120929%2C20120929&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120928%2C20120928&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120927%2C20120927&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120926%2C20120926&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120925%2C20120925&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120924%2C20120924&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120923%2C20120923&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120922%2C20120922&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120921%2C20120921&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120920%2C20120920&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120919%2C20120919&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120918%2C20120918&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120917%2C20120917&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120916%2C20120916&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120915%2C20120915&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120914%2C20120914&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120913%2C20120913&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120912%2C20120912&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120911%2C20120911&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120910%2C20120910&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120909%2C20120909&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120908%2C20120908&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120907%2C20120907&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120906%2C20120906&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120905%2C20120905&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120904%2C20120904&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120903%2C20120903&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120902%2C20120902&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120901%2C20120901&s_dup=1&p=1",
////						Aug			
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120831%2C20120831&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120830%2C20120830&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120829%2C20120829&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120828%2C20120828&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120827%2C20120827&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120826%2C20120826&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120825%2C20120825&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120824%2C20120824&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120823%2C20120823&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120822%2C20120822&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120821%2C20120821&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120820%2C20120820&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120819%2C20120819&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120818%2C20120818&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120817%2C20120817&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120816%2C20120816&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120815%2C20120815&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120814%2C20120814&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120813%2C20120813&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120812%2C20120812&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120811%2C20120811&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120810%2C20120810&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120809%2C20120809&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120808%2C20120808&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120807%2C20120807&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120806%2C20120806&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120805%2C20120805&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120804%2C20120804&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120803%2C20120803&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120802%2C20120802&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120809%2C20120801&s_dup=1&p=1",
////						JUl
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20121231%2C20120731&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120730%2C20120730&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120729%2C20120729&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120728%2C20120728&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120727%2C20120727&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120726%2C20120726&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120725%2C20120725&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120724%2C20120724&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120723%2C20120723&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120722%2C20120722&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120721%2C20120721&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120720%2C20120720&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120719%2C20120719&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120718%2C20120718&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120717%2C20120717&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120716%2C20120716&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120715%2C20120715&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120714%2C20120714&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120713%2C20120713&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120712%2C20120712&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120711%2C20120711&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120710%2C20120710&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120709%2C20120709&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120708%2C20120708&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120707%2C20120707&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120706%2C20120706&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120705%2C20120705&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120704%2C20120704&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120703%2C20120703&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120702%2C20120702&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120709%2C20120701&s_dup=1&p=1",
////						Jun
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120630%2C20120630&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120629%2C20120629&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120628%2C20120628&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120627%2C20120627&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120626%2C20120626&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120625%2C20120625&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120624%2C20120624&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120623%2C20120623&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120622%2C20120622&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120621%2C20120621&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120620%2C20120620&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120619%2C20120619&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120618%2C20120618&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120617%2C20120617&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120616%2C20120616&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120615%2C20120615&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120614%2C20120614&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120613%2C20120613&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120612%2C20120612&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120611%2C20120611&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120610%2C20120610&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120609%2C20120609&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120608%2C20120608&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120607%2C20120607&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120606%2C20120606&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120605%2C20120605&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120604%2C20120604&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120603%2C20120603&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120602%2C20120602&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120601%2C20120601&s_dup=1&p=1",
//
////						May
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120531%2C20120531&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120530%2C20120530&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120529%2C20120529&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120528%2C20120528&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120527%2C20120527&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120526%2C20120526&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120525%2C20120525&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120524%2C20120524&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120523%2C20120523&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120522%2C20120522&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120521%2C20120521&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120520%2C20120520&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120519%2C20120519&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120518%2C20120518&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120517%2C20120517&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120516%2C20120516&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120515%2C20120515&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120514%2C20120514&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120513%2C20120513&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120512%2C20120512&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120511%2C20120511&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120510%2C20120510&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120509%2C20120509&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120508%2C20120508&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120507%2C20120507&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120506%2C20120506&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120505%2C20120505&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120504%2C20120504&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120503%2C20120503&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120502%2C20120502&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120509%2C20120501&s_dup=1&p=1",
////						Apr
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120430%2C20120430&s_dup=1&p=1",
//			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120429%2C20120429&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120428%2C20120428&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120427%2C20120427&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120426%2C20120426&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120425%2C20120425&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120424%2C20120424&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120423%2C20120423&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120422%2C20120422&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120421%2C20120421&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120420%2C20120420&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120419%2C20120419&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120418%2C20120418&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120417%2C20120417&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120416%2C20120416&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120415%2C20120415&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120414%2C20120414&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120413%2C20120413&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120412%2C20120412&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120411%2C20120411&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120410%2C20120410&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120409%2C20120409&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120408%2C20120408&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120407%2C20120407&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120406%2C20120406&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120405%2C20120405&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120404%2C20120404&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120403%2C20120403&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120402%2C20120402&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120401%2C20120401&s_dup=1&p=1",
//					Mar
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120331%2C20120331&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120330%2C20120330&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120329%2C20120329&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120328%2C20120328&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120327%2C20120327&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120326%2C20120326&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120325%2C20120325&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120324%2C20120324&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120323%2C20120323&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120322%2C20120322&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120321%2C20120321&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120320%2C20120320&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120319%2C20120319&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120318%2C20120318&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120317%2C20120317&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120316%2C20120316&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120315%2C20120315&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120314%2C20120314&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120313%2C20120313&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120312%2C20120312&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120311%2C20120311&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120310%2C20120310&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120309%2C20120309&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120308%2C20120308&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120307%2C20120307&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120306%2C20120306&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120305%2C20120305&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120304%2C20120304&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120303%2C20120303&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120302%2C20120302&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120309%2C20120301&s_dup=1&p=1",
//			      Feb
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120229%2C20120229&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120228%2C20120228&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120227%2C20120227&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120226%2C20120226&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120225%2C20120225&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120224%2C20120224&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120223%2C20120223&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120222%2C20120222&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120221%2C20120221&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120220%2C20120220&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120219%2C20120219&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120218%2C20120218&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120217%2C20120217&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120216%2C20120216&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120215%2C20120215&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120214%2C20120214&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120213%2C20120213&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120212%2C20120212&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120211%2C20120211&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120210%2C20120210&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120209%2C20120209&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120208%2C20120208&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120207%2C20120207&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120206%2C20120206&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120205%2C20120205&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120204%2C20120204&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120203%2C20120203&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120202%2C20120202&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120201%2C20120201&s_dup=1&p=1",
//					Jan
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120131%2C20120131&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120130%2C20120130&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120129%2C20120129&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120128%2C20120128&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120127%2C20120127&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120126%2C20120126&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120125%2C20120125&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120124%2C20120124&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120123%2C20120123&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120122%2C20120122&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120121%2C20120121&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120120%2C20120120&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120119%2C20120119&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120118%2C20120118&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120117%2C20120117&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120116%2C20120116&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120115%2C20120115&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120114%2C20120114&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120113%2C20120113&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120112%2C20120112&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120111%2C20120111&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120110%2C20120110&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120109%2C20120109&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120108%2C20120108&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120107%2C20120107&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120106%2C20120106&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120105%2C20120105&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120104%2C20120104&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120103%2C20120103&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120102%2C20120102&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20120101%2C20120101&s_dup=1&p=1",
//		************************************************2012 end*************************************************************************
//    	************************************************2011 begin*************************************************************************
//															Dec
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111231%2C20110731&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111230%2C20111230&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111229%2C20111229&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111228%2C20111228&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111227%2C20111227&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111226%2C20111226&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111225%2C20111225&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111224%2C20111224&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111223%2C20111223&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111222%2C20111222&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111221%2C20111221&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111220%2C20111220&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111219%2C20111219&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111218%2C20111218&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111217%2C20111217&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111216%2C20111216&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111215%2C20111215&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111214%2C20111214&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111213%2C20111213&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111212%2C20111212&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111211%2C20111211&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111210%2C20111210&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111209%2C20111209&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111208%2C20111208&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111207%2C20111207&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111206%2C20111206&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111205%2C20111205&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111204%2C20111204&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111203%2C20111203&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111202%2C20111202&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111209%2C20111201&s_dup=1&p=1",
			//			Nov
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111130%2C20111130&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111129%2C20111129&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111128%2C20111128&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111127%2C20111127&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111126%2C20111126&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111125%2C20111125&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111124%2C20111124&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111123%2C20111123&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111122%2C20111122&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111121%2C20111121&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111120%2C20111120&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111119%2C20111119&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111118%2C20111118&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111117%2C20111117&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111116%2C20111116&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111115%2C20111115&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111114%2C20111114&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111113%2C20111113&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111112%2C20111112&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111111%2C20111111&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111110%2C20111110&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111109%2C20111109&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111108%2C20111108&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111107%2C20111107&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111106%2C20111106&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111105%2C20111105&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111104%2C20111104&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111103%2C20111103&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111102%2C20111102&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111101%2C20111101&s_dup=1&p=1",
			//			Oct
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111031%2C20111031&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111030%2C20111030&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111029%2C20111029&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111028%2C20111028&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111027%2C20111027&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111026%2C20111026&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111025%2C20111025&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111024%2C20111024&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111023%2C20111023&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111022%2C20111022&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111021%2C20111021&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111020%2C20111020&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111019%2C20111019&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111018%2C20111018&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111017%2C20111017&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111016%2C20111016&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111015%2C20111015&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111014%2C20111014&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111013%2C20111013&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111012%2C20111012&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111011%2C20111011&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111010%2C20111010&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111009%2C20111009&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111008%2C20111008&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111007%2C20111007&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111006%2C20111006&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111005%2C20111005&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111004%2C20111004&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111003%2C20111003&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111002%2C20111002&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111009%2C20111001&s_dup=1&p=1",
			//			Sep
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110930%2C20110930&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110929%2C20110929&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110928%2C20110928&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110927%2C20110927&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110926%2C20110926&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110925%2C20110925&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110924%2C20110924&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110923%2C20110923&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110922%2C20110922&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110921%2C20110921&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110920%2C20110920&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110919%2C20110919&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110918%2C20110918&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110917%2C20110917&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110916%2C20110916&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110915%2C20110915&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110914%2C20110914&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110913%2C20110913&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110912%2C20110912&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110911%2C20110911&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110910%2C20110910&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110909%2C20110909&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110908%2C20110908&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110907%2C20110907&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110906%2C20110906&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110905%2C20110905&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110904%2C20110904&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110903%2C20110903&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110902%2C20110902&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110901%2C20110901&s_dup=1&p=1",
			//			Aug			
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110831%2C20110831&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110830%2C20110830&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110829%2C20110829&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110828%2C20110828&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110827%2C20110827&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110826%2C20110826&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110825%2C20110825&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110824%2C20110824&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110823%2C20110823&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110822%2C20110822&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110821%2C20110821&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110820%2C20110820&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110819%2C20110819&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110818%2C20110818&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110817%2C20110817&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110816%2C20110816&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110815%2C20110815&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110814%2C20110814&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110813%2C20110813&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110812%2C20110812&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110811%2C20110811&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110810%2C20110810&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110809%2C20110809&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110808%2C20110808&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110807%2C20110807&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110806%2C20110806&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110805%2C20110805&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110804%2C20110804&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110803%2C20110803&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110802%2C20110802&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110809%2C20110801&s_dup=1&p=1",
			//			JUl
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20111231%2C20110731&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110730%2C20110730&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110729%2C20110729&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110728%2C20110728&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110727%2C20110727&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110726%2C20110726&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110725%2C20110725&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110724%2C20110724&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110723%2C20110723&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110722%2C20110722&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110721%2C20110721&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110720%2C20110720&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110719%2C20110719&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110718%2C20110718&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110717%2C20110717&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110716%2C20110716&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110715%2C20110715&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110714%2C20110714&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110713%2C20110713&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110712%2C20110712&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110711%2C20110711&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110710%2C20110710&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110709%2C20110709&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110708%2C20110708&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110707%2C20110707&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110706%2C20110706&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110705%2C20110705&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110704%2C20110704&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110703%2C20110703&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110702%2C20110702&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110709%2C20110701&s_dup=1&p=1",
			//			Jun
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110630%2C20110630&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110629%2C20110629&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110628%2C20110628&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110627%2C20110627&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110626%2C20110626&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110625%2C20110625&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110624%2C20110624&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110623%2C20110623&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110622%2C20110622&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110621%2C20110621&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110620%2C20110620&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110619%2C20110619&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110618%2C20110618&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110617%2C20110617&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110616%2C20110616&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110615%2C20110615&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110614%2C20110614&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110613%2C20110613&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110612%2C20110612&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110611%2C20110611&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110610%2C20110610&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110609%2C20110609&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110608%2C20110608&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110607%2C20110607&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110606%2C20110606&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110605%2C20110605&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110604%2C20110604&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110603%2C20110603&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110602%2C20110602&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110601%2C20110601&s_dup=1&p=1",
			
			//			May
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110531%2C20110531&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110530%2C20110530&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110529%2C20110529&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110528%2C20110528&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110527%2C20110527&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110526%2C20110526&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110525%2C20110525&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110524%2C20110524&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110523%2C20110523&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110522%2C20110522&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110521%2C20110521&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110520%2C20110520&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110519%2C20110519&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110518%2C20110518&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110517%2C20110517&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110516%2C20110516&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110515%2C20110515&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110514%2C20110514&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110513%2C20110513&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110512%2C20110512&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110511%2C20110511&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110510%2C20110510&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110509%2C20110509&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110508%2C20110508&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110507%2C20110507&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110506%2C20110506&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110505%2C20110505&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110504%2C20110504&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110503%2C20110503&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110502%2C20110502&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110509%2C20110501&s_dup=1&p=1",
			//			Apr
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110430%2C20110430&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110429%2C20110429&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110428%2C20110428&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110427%2C20110427&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110426%2C20110426&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110425%2C20110425&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110424%2C20110424&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110423%2C20110423&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110422%2C20110422&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110421%2C20110421&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110420%2C20110420&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110419%2C20110419&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110418%2C20110418&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110417%2C20110417&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110416%2C20110416&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110415%2C20110415&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110414%2C20110414&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110413%2C20110413&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110412%2C20110412&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110411%2C20110411&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110410%2C20110410&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110409%2C20110409&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110408%2C20110408&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110407%2C20110407&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110406%2C20110406&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110405%2C20110405&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110404%2C20110404&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110403%2C20110403&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110402%2C20110402&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110401%2C20110401&s_dup=1&p=1",
			//		Mar
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110331%2C20110331&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110330%2C20110330&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110329%2C20110329&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110328%2C20110328&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110327%2C20110327&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110326%2C20110326&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110325%2C20110325&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110324%2C20110324&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110323%2C20110323&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110322%2C20110322&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110321%2C20110321&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110320%2C20110320&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110319%2C20110319&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110318%2C20110318&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110317%2C20110317&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110316%2C20110316&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110315%2C20110315&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110314%2C20110314&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110313%2C20110313&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110312%2C20110312&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110311%2C20110311&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110310%2C20110310&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110309%2C20110309&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110308%2C20110308&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110307%2C20110307&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110306%2C20110306&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110305%2C20110305&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110304%2C20110304&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110303%2C20110303&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110302%2C20110302&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110309%2C20110301&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20140415%2C20140415&s_dup=1&p=26&",
			//      Feb
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110229%2C20110229&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110228%2C20110228&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110227%2C20110227&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110226%2C20110226&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110225%2C20110225&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110224%2C20110224&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110223%2C20110223&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110222%2C20110222&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110221%2C20110221&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110220%2C20110220&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110219%2C20110219&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110218%2C20110218&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110217%2C20110217&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110216%2C20110216&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110215%2C20110215&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110214%2C20110214&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110213%2C20110213&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110212%2C20110212&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110211%2C20110211&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110210%2C20110210&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110209%2C20110209&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110208%2C20110208&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110207%2C20110207&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110206%2C20110206&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110205%2C20110205&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110204%2C20110204&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110203%2C20110203&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110202%2C20110202&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110201%2C20110201&s_dup=1&p=1",
			//		Jan
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110131%2C20110131&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110130%2C20110130&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110129%2C20110129&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110128%2C20110128&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110127%2C20110127&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110126%2C20110126&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110125%2C20110125&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110124%2C20110124&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110123%2C20110123&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110122%2C20110122&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110121%2C20110121&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110120%2C20110120&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110119%2C20110119&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110118%2C20110118&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110117%2C20110117&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110116%2C20110116&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110115%2C20110115&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110114%2C20110114&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110113%2C20110113&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110112%2C20110112&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110111%2C20110111&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110110%2C20110110&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110109%2C20110109&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110108%2C20110108&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110107%2C20110107&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110106%2C20110106&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110105%2C20110105&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110104%2C20110104&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110103%2C20110103&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110102%2C20110102&s_dup=1&p=1",
			"http://search.t.qq.com/index.php?pos=211&k=%E6%83%A0%E6%99%AE&s_advanced=1&s_time=20110101%2C20110101&s_dup=1&p=1",
    	};
	
    public static void main(String[] args) throws InterruptedException, IOException, ParseException{
    	FirefoxDriver firefoxDriver = HttpHelper.fireFoxDriver();
    	TencentMicroblogComments tm = new TencentMicroblogComments();
    	String[] urlss=urls;
		for(String s:urlss){
			try{
				
				if(tm.i%30==0){
					if(tm.i!=0){
						firefoxDriver.quit();
						firefoxDriver=HttpHelper.fireFoxDriver();
					}
					int nl=name.length;
					if(tm.j<nl){
						tm.login(loginUrl, name[tm.j], password[tm.j],firefoxDriver);
						tm.j++;
					}else{
						firefoxDriver.quit();
						break;
					}
					
//					break;
				}
				firefoxDriver.get(s);
				Thread.sleep(5000);
				tm.fetchData("惠普",firefoxDriver);
				tm.i++;
			}catch(Exception e){
				e.printStackTrace();
			}
    	
		}
		firefoxDriver.quit();
		System.out.println("-----------------------------------------TencentMicroblogComments end---------------------------------------------------");
//    	
//    	int l=name.length;
//    	while(true){
//    		for(int j=0;j<l;j++){
//        		String qqEmail=name[j];
//        		String qqPassword=password[j];
//        		tm.mainLoop(firefoxDriver, qqEmail, qqPassword, loginUrl);
//        	}
//    	}
			
			
//		String[] keys= {"惠普"};
////		String qqEmail="2948717703@qq.com";//enter your qq email
////		String qqPassword="20130417_20140509";//enter your qq email password
//		String qqEmail="850984363@qq.com";//enter your qq email
//		String qqPassword="ghl,.880501";//enter your qq email password
//		String url = "http://ui.ptlogin2.qq.com/cgi-bin/login?appid=46000101&style=13&lang=&low_login=1&hide_title_bar=1&hide_close_icon=1&self_regurl=http%3A//reg.t.qq.com/index.php&s_url=http%3A%2F%2Ft.qq.com&daid=6";
//		FirefoxDriver firefoxDriver = HttpHelper.fireFoxDriver();
//		tm.login(url, qqEmail, qqPassword,firefoxDriver);
//		String[] urlss=urls;
//		for(String s:urlss){
//			try{
//				tm.i++;
//				if(tm.i%29==0){
//					Thread.sleep(1000*60*60);
//				}
//				firefoxDriver.get(s);
//				Thread.sleep(5000);
//				tm.fetchData(url,keys[0],firefoxDriver);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		
//		firefoxDriver.quit();
//		System.out.println("-----------------------------------------TencentMicroblogComments end---------------------------------------------------");
		
    }
    /**
     * 
     * @param firefoxDriver
     * @param qqEmail enter your qq email String qqEmail="2948717703@qq.com";
     * @param qqPassword String qqPassword="20130417_20140509";//enter your qq email password
     * @throws InterruptedException
     */
    private void mainLoop(FirefoxDriver firefoxDriver,String qqEmail,String qqPassword,String key) throws InterruptedException{
    	TencentMicroblogComments tm = new TencentMicroblogComments();
		String url = "http://ui.ptlogin2.qq.com/cgi-bin/login?appid=46000101&style=13&lang=&low_login=1&hide_title_bar=1&hide_close_icon=1&self_regurl=http%3A//reg.t.qq.com/index.php&s_url=http%3A%2F%2Ft.qq.com&daid=6";
		firefoxDriver = HttpHelper.fireFoxDriver();
		tm.login(url, qqEmail, qqPassword,firefoxDriver);
		String[] urlss=urls;
		for(String s:urlss){
			try{
				tm.i++;
				firefoxDriver.get(s);
				Thread.sleep(5000);
				tm.fetchData(key,firefoxDriver);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		firefoxDriver.quit();
		System.out.println("-----------------------------------------TencentMicroblogComments end---------------------------------------------------");
    }
    private void login(String url,String qqEmail,String qqPassword, FirefoxDriver firefoxDriver) throws InterruptedException{
         firefoxDriver.get(url);
         System.out.println("opened");
          for(int i=0;i<5;i++){
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              firefoxDriver.getKeyboard().pressKey(Keys.PAGE_DOWN);
              Thread.sleep(1000);
          }
          WebElement userNameInput = firefoxDriver.findElement(By.id("u"));
          userNameInput.sendKeys(qqEmail);
          WebElement passwordInput = firefoxDriver.findElement(By.id("p"));
          passwordInput.sendKeys(qqPassword);
          WebElement loginSumbit = firefoxDriver.findElement(By.id("login_button"));
          Thread.sleep(15000);
          loginSumbit.click();
          Thread.sleep(5000);
          
    }
    /*
     * 
     */
    public void fetchData(String key,FirefoxDriver firefoxDriver) throws InterruptedException, IOException, ParseException{
          	fetchRatingTable(firefoxDriver,key);
    }
    
/**
 *     
 * @param firefoxDriver
 * @param key
 * @throws InterruptedException
 * @throws IOException
 */
    private void fetchRatingTable(FirefoxDriver firefoxDriver,String key) throws InterruptedException, IOException{
        WebElement rateGrid = firefoxDriver.findElementById("talkList");
        
        List<WebElement> rateLines = rateGrid.findElements(By.tagName("li"));
        String tab="\t";
        String changeLine="\n";
        String source="tecent weibo";
        StringBuilder sb=null;
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh:mm");
  		SimpleDateFormat newsdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
	    for (WebElement rateLine : rateLines) {
	        	sb=new StringBuilder();
	        	String msgCnt=rateLine.findElement(By.className("msgCnt")).getText();
	        	String userName=rateLine.findElement(By.className("userName")).getText();
	        	String time=rateLine.findElement(By.className("time")).getAttribute("title");
	        	rateLine.findElement(By.className("time")).getAttribute("");
	        	try {
	        	date = sdf.parse(time);
	        	} catch (ParseException e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    			date=new Date();
	    		}
        		time=newsdf.format(date);
        		if(msgCnt.trim().length()!=0){
        			sb.append(userName).append(tab).append(time).append(tab).append(msgCnt).append(tab).append(source).append(changeLine);
    	            System.out.println(sb);
    	            FileUtils.write(new File(RATE_FILE_NAME+"HpHrInfo"+".txt"),sb ,true);
    	       
        		}
	        }
		
		
         System.out.println("============================================================= one page end=============================================================");
        List<WebElement> links = firefoxDriver.findElements(By.className("pageBtn"));
        try{
        	for (WebElement pageLink : links) {
            	System.out.println("text:"+pageLink.getText()+"||"+("下一页 >>".equals(pageLink.getText())) +"||"+(null != (pageLink.getAttribute("href")))+""+pageLink.getAttribute("href"));
                if("下一页 >>".equals(pageLink.getText()) && null != (pageLink.getAttribute("href"))){
            		pageLink.click();
                    Thread.sleep(5000);
                    fetchRatingTable(firefoxDriver ,key);
                }
            }
        }catch(Exception  e){
        	System.out.println();
        	e.printStackTrace();
        }
        System.out.println("=============================================================all of the page read end=============================================================");
       
    }

    public void fetchSalesVolume(FirefoxDriver firefoxDriver, List<DealRecord> records) throws InterruptedException, ParseException{
        
        WebElement tableDealRecord = firefoxDriver.findElementByClassName("table-deal-record");
        
        List<WebElement> rows = tableDealRecord.findElements(By.tagName("tr"));
        
        for(int i=1; i<rows.size();i++){
            
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            
            DealRecord record = new DealRecord();
            record.setConsumerName(columns.get(0).getText());
            record.setProductName(columns.get(1).getText());
            record.setPrice(Double.valueOf(columns.get(2).getText()));
            record.setVolume(Integer.valueOf(columns.get(3).getText()));
            record.setDate(DateFormatter.formatStringToDateTMallDeal(columns.get(4).getText()));
            record.setStatus(columns.get(5).getText());
            records.add(record);
            
        }
       
        try {
            
            WebElement bottomLine = firefoxDriver.findElementByClassName("pagination").findElement(By.className("page-bottom"));
            
            List<WebElement> links = bottomLine.findElements(By.tagName("a"));
            
//            WebElement nextPageLink = links.get((links.size()-1));
            for (WebElement link : links) {
                if("下一页".equals(link.getText())){
                    
                    System.out.println("page change start");
                    link.click();
                    System.out.println("page change end");
                    Thread.sleep(5000);
                    
                    fetchSalesVolume(firefoxDriver,records);
                }
            }
            
           // WebElement nextPageLink = firefoxDriver.findElementByClassName("page-next");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
