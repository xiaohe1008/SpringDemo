package com.hemaobin.webDemo.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hemaobin.webDemo.domain.userVO;
import com.hemaobin.webDemo.service.interfaces.IUserService;

/***
 * spring mvc定时任务
 * @author hemb
 * @date   2019年10月15日
 */
@Component
public class testJob {
//	@Autowired
//	private IUserService IUserService;
//
//	@Scheduled(cron = "0 * * * * ?")
//	public void runJob() {
//		 Date date=new Date();
//		System.out.println(date);
//		userVO userVO=IUserService.findUserById(1);
//		System.out.println(userVO);
//	}
//	
}
