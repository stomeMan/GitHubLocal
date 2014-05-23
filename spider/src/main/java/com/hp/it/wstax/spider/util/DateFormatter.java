/**
 * 
 */
package com.hp.it.wstax.spider.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 * 
 * @author Martin (zhi-yuan.ma@hp.com)
 * @date Dec 20, 2013
 * @revision
 */
public class DateFormatter {

	private static String TMALL_DEAL_RECORD_FORMATTER = "yyyy-MM-dd HH:mm:ss";

	public static Date formatStringToDateTMallDeal(String dateStr)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat(TMALL_DEAL_RECORD_FORMATTER);

		return sdf.parse(dateStr);
	}

	public static String formatDateToStringTMallDeal(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat(TMALL_DEAL_RECORD_FORMATTER);
		return sdf.format(date);
	}

}
