package com.hemaobin.webDemo.collectionUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 时间工具类
 * @author hemb
 * @date   2019年9月14日
 */
public final class DateUtil {

	public static final String ORACLE_DATETIME_FORMAT = "yyyy-MM-dd HH24:mm:ss";

	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DATETIME_FORMAT2 = "yyyyMMdd HH:mm:ss";

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String YYYYMMDD = "yyyyMMdd";

	public static final String YYYYMM = "yyyyMM";

	public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
	
	public static final String DDMMMMYYYY = "dd MMMM,yyyy";
	
	public static final String MMDYYYYHMSAA = "MMM d, yyyy h:m:s aa";

	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

	public static final String TIME_ZONE_UTC = "GMT";

	private DateUtil() {
		// 禁止实例化
	}

	/**
	 *  获取当前时间戳
	 * @return
	 */
	public static long getCurrentTimeMillis() {
		Timestamp time = getSysDate();
		return time.getTime();
	}

	public static String getCurrentTime() throws Exception {
		return getDateString(DATETIME_FORMAT);
	}

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public static Timestamp getSysDate() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 根据指定的格式输入时间字符串
	 * 
	 * @param pattern
	 * @return
	 * @throws Exception 
	 */
	public static String getDateString(String pattern) throws Exception {
		if (StringUtil.isBlank(pattern)) {
			throw new Exception("请指定日期格式");
		}
		Timestamp time = getSysDate();
		DateFormat dfmt = new SimpleDateFormat(pattern);
		java.util.Date date = time;
		return dfmt.format(date);
	}

	/**
	 * 获取时间字符串
	 * 
	 * @param time
	 * @param pattern
	 * @return
	 * @throws Exception 
	 */
	public static String getDateString(Timestamp time, String pattern) throws Exception {
		if (time == null) {
			throw new Exception("请指定时间");
		}
		if (StringUtil.isBlank(pattern)) {
			throw new Exception("请指定格式");
		}
		DateFormat dfmt = new SimpleDateFormat(pattern);
		java.util.Date date = time;
		return date != null ? dfmt.format(date) : "";
	}

	/**
	 * 获取指定时间的格式化串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(Date date, String pattern) throws Exception {
		if (date == null) {
			throw new Exception("请指定时间");
		}
		if (StringUtil.isBlank(pattern)) {
			throw new Exception("请指定格式");
		}
		SimpleDateFormat sdfmt = new SimpleDateFormat(pattern);
		return date != null ? sdfmt.format(date) : "";
	}
	/**
	 * 获取指定时间的格式化串
	 * 
	 * @param date
	 * @param pattern
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static String getDateString(Date date, String pattern, Locale locale) throws Exception {
	  if (date == null) {
	    throw new Exception("请指定时间");
	  }
	  if (StringUtil.isBlank(pattern)) {
	    throw new Exception("请指定格式");
	  }
	  SimpleDateFormat sdfmt = new SimpleDateFormat(pattern, locale);
	  return date != null ? sdfmt.format(date) : "";
	}
	/**
	 * 获取一天的第一秒 如：2011-11-11 00:00:00
	 * @param sysDate
	 * @return
	 */
	public static Timestamp getTheDayFirstSecond(Timestamp sysDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sysDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.SECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}
	/**
	 * 获取一天的最后一秒 如：2011-11-11 23:59:59
	 * @param sysDate
	 * @return
	 */
	public static Timestamp getTheDayLastSecond(Timestamp sysDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sysDate);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return new Timestamp(calendar.getTimeInMillis());
	}
	/**
	 * 获取指定时间的偏移天数后的时间
	 * 
	 * @param sysDate
	 * @param offsetDays
	 * @return
	 */
	public static Timestamp getOffsetDaysTime(Timestamp sysDate, int offsetDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sysDate);
		calendar.add(Calendar.DAY_OF_MONTH, offsetDays);
		return new Timestamp(calendar.getTimeInMillis());
	}
	public static Date getOffsetDaysDate(Date date, int offsetDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, offsetDays);
		return new Date(calendar.getTimeInMillis());
	}
}

