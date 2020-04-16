package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hemaobin.webDemo.collectionUtils.StringUtil;
import com.hemaobin.webDemo.domain.emailVO;
import com.hemaobin.webDemo.domain.userVO;
import com.hemaobin.webDemo.service.impl.UserServiceImpl;
import com.hemaobin.webDemo.service.interfaces.IEmailService;
import com.hemaobin.webDemo.service.interfaces.IUserService;

public class IUserServiceTest {
	private Logger log= Logger.getLogger(IUserServiceTest.class);
	
	@Autowired
	private IUserService iUserService;
	public void show() {
		log.info("=============>>>>正在保存用户信息>>>>>==========");
		log.info("=============>>>>正在保存用户信息>>>>>==========");
		log.error("无法找到配置文件");
		log.info("=============>>>>正在保存用户信息>>>>>==========");
	}
	@Test
	public void testUpdataUser() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		IUserService iUserService=ac.getBean("userService", IUserService.class);
//		userVO user=new userVO();
//		user.setUserId(3);
//		user.setEmail("12356789@qq.com");
//		user.setPsw("123456");
//		user.setAddress("福建漳州云霄马铺");
//		user.setAge(10);
//		user.setUserName("xiaoxiao");
//		user.setSex("男");
//		user.setTel("13328825467");
		System.out.println(iUserService.login("1766282543@qq.com","123"));
	}
	@Test
	public void sendEmailTest() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		IEmailService iEmailService=ac.getBean("emailService", IEmailService.class);
		emailVO emailVO=new emailVO();
		iEmailService.sendEmail(emailVO);
	}

}
