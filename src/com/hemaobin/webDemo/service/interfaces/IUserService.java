package com.hemaobin.webDemo.service.interfaces;

import java.util.List;

import com.hemaobin.webDemo.domain.userVO;

public interface IUserService {

	/**
	 * 保存用户基本信息
	 * @param user
	 * @throws Exception
	 */
	public void saveUser(userVO user) throws Exception;
	
	/**
	 * 根据条件查询用户----管理员使用
	 * @param user 
	 * @return
	 */
	public List<userVO>findUserByCondition(userVO  user);
	
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	public userVO findUserById(long id);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @throws Exception
	 */
	public void updataUser(userVO user) throws Exception;
	
	/**
	 * 对用户进行封号、解封处理----管理员使用
	 * @param id  要进行处理的用户id
	 * @param action 要进行的操作   true--解封  false--封号
	 * @throws Exception
	 */
	public void deleteUserById(long id,boolean action) throws Exception;
	
	public userVO login(String account,String password) throws Exception;
}
