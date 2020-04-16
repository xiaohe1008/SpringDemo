package com.hemaobin.webDemo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.hemaobin.webDemo.atom.interfaces.IUserDao;
import com.hemaobin.webDemo.collectionUtils.StringUtil;
import com.hemaobin.webDemo.constant.finalTest;
import com.hemaobin.webDemo.domain.userVO;
import com.hemaobin.webDemo.service.interfaces.IUserService;

public class UserServiceImpl implements IUserService {
	private Logger log= Logger.getLogger(UserServiceImpl.class);
	
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(userVO user) throws Exception {
		if (user==null) {
			throw new Exception("Param is null");
		}
		log.debug("=============>>>>正在保存用户信息>>>>>==========");
		userDao.save(user);
		log.debug("=============>>>>用户信息保存成功>>>>>==========");
	}

	@Override
	public List<userVO> findUserByCondition(userVO user) {
		String userName =user.getUserName();
		String email=user.getEmail();
		String statusDesc=user.getStatusDesc();
		int age=user.getAge();
		String sex=user.getSex();
		String sql="select * from user where 1=1";
		if (!StringUtil.isBlank(userName)) {
			sql=" and username is like %"+userName+"%";
		}
		if (!StringUtil.isBlank(email)) {
			sql=sql+" and email="+"'"+email+"'";
		}
		if (!StringUtil.isBlank(statusDesc)) {
			if (statusDesc.equals(finalTest.userAccount.STATUS_0_DESC)) {
				sql=sql+" and status="+0;
			}else {
				sql=sql+" and status="+1;
			}
		}
		if(0<age&&age<120) {
			sql=sql+" and age="+age;
		}
		if(!StringUtil.isBlank(sex)) {
			sql=sql+" and sex="+"'"+sex+"'";
		}
		//数据库sql语句测试
//		System.out.println(sql);
		return userDao.findUserByCondition(sql);
	}

	@Override
	public userVO findUserById(long id) {
		userVO userVO=null;
		if (id!=0L) {
			List<userVO> userVOs=userDao.get(id);
			if (!userVOs.isEmpty()) {
				userVO = userVOs.get(0);
				// 翻译供前端使用
				int status = userVO.getStatus();
				if (status == 1) {
					userVO.setStatusDesc(finalTest.userAccount.STATUS_1_DESC);
				} else {
					userVO.setStatusDesc(finalTest.userAccount.STATUS_0_DESC);
				}
			}
		}
		return userVO;
	}

	@Override
	public void updataUser(userVO user) throws Exception {
		long id=user.getUserId();
		String userName =user.getUserName();
		String email=user.getEmail();
		//确认用户是否存在
		userVO userVO=findUserById(id);
		int age=user.getAge();
		String sex=user.getSex();
		String password=user.getPsw();
		String telephone=user.getTel();
		String address=user.getAddress();
		if (userVO==null||id==0) {
			throw new Exception("用户不存在");
		}
		String sql="update user set ";
		if (!StringUtil.isBlank(userName)) {
			sql=sql+"username ="+"'"+userName+"',";
		}
		if (!StringUtil.isBlank(email)) {
			sql=sql+" email="+"'"+email+"',";
		}
		if(0<age&&age<120) {
			sql=sql+" age="+age+",";
		}
		if(!StringUtil.isBlank(sex)) {
			sql=sql+" sex="+"'"+sex+"',";
		}
		if(!StringUtil.isBlank(telephone)) {
			sql=sql+" tel="+"'"+telephone+"',";
		}
		if(!StringUtil.isBlank(password)) {
			sql=sql+" psw="+"'"+password+"',";
		}
		if(!StringUtil.isBlank(address)) {
			sql=sql+" address="+"'"+address+"',";
		}
		sql=sql+" status="+1+"  where 1=1 and userid="+id;
		//数据库sql语句测试
//		System.out.println(sql);
		userDao.updataUserById(sql);
	}

	@Override
	public void deleteUserById(long id, boolean action) throws Exception {
		String sql="";
		userVO userVO=findUserById(id);
		if (id==0||userVO==null) {
			throw new Exception("用户不存在");
		}
		if (action) {
			sql="update user set status="+1+" where 1=1 and userid="+id;
		} else {
			 sql="update user set status="+0+" where 1=1 and userid="+id;
		}
		//数据库sql语句测试
//		System.out.println(sql);
		userDao.updataUserById(sql);
	}

	@Override
	public userVO login(String account, String password) throws Exception {
		String sql="select * from user";
		userVO result=null;
		if (StringUtil.isBlank(account)||StringUtil.isBlank(password)) {
			throw new Exception("账号或密码不能为空");
		}
		sql=sql+" where 1=1 and email="+"'"+account+"'"+"  and psw="+"'"+password+"'";
		List<userVO> userVOs=userDao.login(sql);
//		System.out.println(sql);
		if (!userVOs.isEmpty()) {
			result=userVOs.get(0);
			// 翻译供前端使用
			int status = result.getStatus();
			if (status == 1) {
				result.setStatusDesc(finalTest.userAccount.STATUS_1_DESC);
			} else {
				result.setStatusDesc(finalTest.userAccount.STATUS_0_DESC);
			}
		}
		return result;
	}
}
