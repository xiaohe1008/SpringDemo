package com.hemaobin.webDemo.service.interfaces;

import com.hemaobin.webDemo.domain.emailVO;

public interface IEmailService {
  
	/**
	 * 发送邮件
	 * @param emailVO 邮件构成部分包括内容、主题、收件人
	 * @return true 发送成功    false 发送失败
	 * @throws Exception
	 */
	public boolean sendEmail(emailVO emailVO) throws Exception;
}
