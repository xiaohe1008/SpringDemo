package com.hemaobin.webDemo.ctrl;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hemaobin.webDemo.collectionUtils.StringUtil;
import com.hemaobin.webDemo.domain.userVO;
import com.hemaobin.webDemo.service.interfaces.IUserService;
@Controller("userController")
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/login")
	public String login(String email,String psw,HttpSession httpSession) {
		String result="";
		String message="";
		String account=email;
		String password=psw;
		try {
			userVO userDb=iUserService.login(account,password);
			int status=userDb.getStatus();
			if (userDb != null&&status==1) {
				message="登陆成功";
//				System.out.println(message);
				 httpSession.setAttribute("userInfo", userDb);//登陆成功
			}else {
				if (status==0) {
					message="账号被封锁，请联系管理员";
					System.out.println(message);//账号或密码错误
				}else {
					message="账号或密码错误";
					System.out.println(message);//账号或密码错误
				}
			}
			result="success";
			httpSession.setAttribute("message", message);
		} catch (Exception e) {
			result="error";
			e.printStackTrace();
		}
		
		return result;
	}
	

	@RequestMapping("/saveUser")
	public String saveUser(userVO user) {
		String result="";
		try {
			iUserService.saveUser(user);
			result="success";
		} catch (Exception e) {
			result="error";
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/queryUserById")
	public String queryUserById(long id) {
		String result="";
		try {
			System.out.println(iUserService.findUserById(id));
			result="success";
		} catch (Exception e) {
			result="error";
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/queryUserByCondition")
	public String queryUserByCondition(userVO user) {
		String result="";
		try {
			iUserService.findUserByCondition(user);
			result="success";
		} catch (Exception e) {
			result="error";
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("/updateUserById")
	public String updateUserById(userVO user,HttpSession session) {
		String result = "";
		long id=user.getUserId();
		String userName =user.getUserName();
		String email=user.getEmail();
		int age=user.getAge();
		String sex=user.getSex();
		String password=user.getPsw();
		String telephone=user.getTel();
		String address=user.getAddress();
		try {
			userVO userVO = (com.hemaobin.webDemo.domain.userVO) session.getAttribute("userInfo");
			//刷新session
			if (id!=0&&user!=null) {
				if (!StringUtil.isBlank(userName)) {
					userVO.setUserName(userName);
				}
				if (!StringUtil.isBlank(email)) {
					userVO.setEmail(email);
				}
				if(0<age&&age<120) {
					userVO.setAge(age);
				}
				if(!StringUtil.isBlank(sex)) {
					userVO.setSex(sex);
				}
				if(!StringUtil.isBlank(telephone)) {
					userVO.setTel(telephone);
				}
				if(!StringUtil.isBlank(password)) {
					userVO.setPsw(password);
				}
				if(!StringUtil.isBlank(address)) {
					userVO.setAddress(address);
				}
			}
			//修改数据库
			iUserService.updataUser(user);
			result = "success";
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("/deleteUserById")
	public String deleteUserById(long id,boolean action) {
		String result="";
		try {
			iUserService.deleteUserById(id, action);;
			result="success";
		} catch (Exception e) {
			result="error";
			e.printStackTrace();
		}
		return result;
	}
}
