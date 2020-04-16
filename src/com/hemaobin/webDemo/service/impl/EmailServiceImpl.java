package com.hemaobin.webDemo.service.impl;
import com.hemaobin.sendemail.emailAssit;
import com.hemaobin.webDemo.collectionUtils.StringUtil;
import com.hemaobin.webDemo.domain.emailVO;
import com.hemaobin.webDemo.service.interfaces.IEmailService;

public class EmailServiceImpl implements IEmailService {

	
	private String smtpHost;
	
	private String yourEmail;
	
	private String secretKey;
	
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}


	@Override
	public boolean sendEmail(emailVO emailVO) throws Exception {
		boolean result = false;
		if (emailVO == null) {
			throw new Exception("param is null");
		}
		if (!StringUtil.isBlank(smtpHost) && !StringUtil.isBlank(yourEmail) && !StringUtil.isBlank(secretKey)) {
			System.out.println(smtpHost+"  "+yourEmail+"  "+secretKey);
			String hisEmail = emailVO.getHisEmail();
			String content = emailVO.getContent();
			String theme = emailVO.getTheme();
			if (!StringUtil.isBlank(hisEmail) && !StringUtil.isBlank(content) && !StringUtil.isBlank(theme)) {
				//信封
				emailAssit assit = new emailAssit();
				 //发信人相关信息
				assit.setSmtpHost(smtpHost);//如果使用163邮箱，修改为smtp.163.com
				assit.setFromEmail(yourEmail);
				assit.setPassword(secretKey);
				//收信人及邮箱格式
				assit.sendMessage(hisEmail, content, theme);
				result = true;
			}
		}
		return result;
	}

}
