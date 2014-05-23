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
public class Constants {
    
    public static String DEFAULT_PROXY_HOST = "web-proxy-sha.chn.hp.com";
    
    public static int DEFAULT_PROXY_PORT = 8080;
    
    public static String TMALL_HP_ALL_PRODUCT_PAGE_URL =
            //"http://hp.tmall.com/category-501732900.htm?spm=a1z10.5.0.0.msZYbV&search=y&parentCatId=439229060&parentCatName=%BB%DD%C6%D5%B1%CA%BC%C7%B1%BE&catName=%B1%CA%BC%C7%B1%BE%D6%AE%B6%C0%CF%D42G";
            "http://hp.tmall.com/category-439229060.htm?spm=a1z10.5.w4011-3157313454.64.cz0vlt&mid=w-3157313454-0&catName=%BB%DD%C6%D5%B1%CA%BC%C7%B1%BE&catId=439229060&search=y&orderType=hotsell_desc";

    public static String TMALL_DELL_PRODUCT_CATEGORY_URL = 
            "http://dell.tmall.com/category-174761481.htm?spm=a1z10.5.w4011-2633652766.62.sY9xIw&mid=w-2633652766-0&catName=%BC%D2%D3%C3%B1%CA%BC%C7%B1%BE&catId=174761481&search=y&orderType=";
    
    public static String TMALL_THINKPAD_PRODUCT_CATEGORY_URL = 
            "http://thinkpad.tmall.com/search.htm?spm=a1z10.1.0.0.TxparY&search=y&orderType=hotsell_desc";
    
    public static String TMALL_HP_PRINTER_CATEGORY_URL = 
            "http://hpdyj.tmall.com/search.htm?spm=a1z10.3.w4011-3496100863.3.0FmMFq&mid=w-3496100863-0&search=y&orderType=&tsearch=y";
    
    public static String TMALL_SONY_PRODUCT_CATEGORY_URL =
    		"http://sonyzs.tmall.com/category-440584320.htm?spm=a220o.1000855.w5002-3148666783.3.i7dhWY&search=y&catName=%B8%F6%C8%CB%B5%E7%C4%D4";
    
    public static String TMALL_SAMSUNG_PRODUCT_CATEGORY_URL="http://samsung.tmall.com/category-169445648.htm?spm=a1z10.5.w5001-3161583478.6.sgxkWx&search=y&scene=taobao_shop#TmshopSrchNav";
    
    public static String TMALL_Toshiba_ALL_PRODUCT_PAGE_URL =
    		"http://toshiba.tmall.com/category-786900885.htm?spm=a220o.1000855.w5001-5114507873.3.w04CvY&search=y&catName=%B1%CA%BC%C7%B1%BE%B5%E7%C4%D4&scene=taobao_shop";
    
    public static String TMALL_Fujitsu_PRODUCT_CATEGORY_URL="http://fujitsu.tmall.com/category-437672554.htm?spm=a1z10.4.0.0.0kRNwn&search=y&catName=%B2%FA%C6%B7%B6%A8%CE%BB%B7%D6%C0%E0";

    
    // www.yixun.com
    public static String YIXUN_HP_ALL_PRODUCT_PAGE_URL = 
            "http://searchex.yixun.com/html?YTAG=3.21041103&key=HP&as=1&attr=55e5706&area=1";
    // the text of next page html element in yixun
    public static String NEXT_PAGE_TEXT_YIXUN = "下一页";
    
    public static String YIXUN_HP_ALL_PRODUCT_PAGE_SECOND_URL = 
    		"http://searchex.yixun.com/html?attr=55e5706&key=HP&area=1&sort=0&show=0&page=2&size=40&as=1&charset=utf-8&YTAG=3.21041103#list";

    public static String DB_CONN_URL= "jdbc:vertica://16.158.82.140:5433/Vertica";
            //"jdbc:sqlserver://localhost:1433; DatabaseName=bigdatapoc";
    
    public static String DB_USER_NAME = "dbadmin";
            //"sa";
    
    public static String DB_PASSWORD = "password";
            //"Zyuanm00";
    
    public static String JDBC_DRIVER = "com.vertica.jdbc.Driver";
    
    public static String SINA_WEIBO_HP_COMPUTER = "http://s.weibo.com/weibo/%25E6%2583%25A0%25E6%2599%25AE%25E7%2594%25B5%25E8%2584%2591?topnav=1&wvr=5&b=1";
    
    public static String SINA_WEIBO_HP_LAPTOP = "http://s.weibo.com/weibo/%25E6%2583%25A0%25E6%2599%25AE%25E7%25AC%2594%25E8%25AE%25B0%25E6%259C%25AC&Refer=STopic_box";
    
    public static String SINA_WEIBO_HP_PRINTER = "http://s.weibo.com/weibo/%25E6%2583%25A0%25E6%2599%25AE%25E6%2589%2593%25E5%258D%25B0%25E6%259C%25BA?topnav=1&wvr=5&b=1";
    
    public static String TMALL_CANON_PRINTER = "http://canoncd.tmall.com/?q=%B4%F2%D3%A1%BB%FA&type=p&style=&cat=all&search=y&newHeader_b=s_from&searcy_type=item";
    
    public static String TMALL_FUSHITONG_PRINTER = "http://kangyuebg.tmall.com/category.htm?orderType=defaultSort&viewType=grid&catId=706126020&keyword=%B8%BB%CA%BF%CD%A8&lowPrice=&highPrice=";
    
    public static String TMALL_THINKPAD_PRINTER = "http://fzbg.tmall.com/category-809386606.htm?spm=a1z10.3.w4011-4163379906.37.B6PlIn&mid=w-4163379906-0&type=p&cat=all&newHeader_b=s_from&searcy_type=item&catId=809386606&keyword=%B4%F2%D3%A1%BB%FA&csy=1&pv=20000:11119&tsearch=y#TmshopSrchNav";

    public static String SINA_WEIBO_HP_ELITEBOOK = "http://s.weibo.com/weibo/Elitebook&Refer=STopic_box";

    public static String SINA_WEIBO_HP_ENVY = "http://s.weibo.com/weibo/Envy&Refer=STopic_box";
    
    public static String SINA_WEIBO_SEARCH = "http://s.weibo.com/weibo/<keywords>&Refer=STopic_box";
}
