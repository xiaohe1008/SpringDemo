package com.hemaobin.webDemo.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;
/**
 * �Զ�������ת����
 * @author zydx
 *
 */
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		DateFormat format=null;
		if(StringUtils.isEmpty(arg0)) {
			throw new NullPointerException("�봫����ȷ��ֵ");
		}
		try {
			format=new SimpleDateFormat("yyyy-MM-dd");
			Date date=format.parse(arg0);
			return date;
		} catch (ParseException e) {
			throw new RuntimeException("��������ȷ�����ڸ�ʽyyyy-MM-dd");
		}
	}

}
