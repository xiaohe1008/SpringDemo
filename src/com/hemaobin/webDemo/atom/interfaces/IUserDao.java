package com.hemaobin.webDemo.atom.interfaces;

import java.util.List;

import com.hemaobin.webDemo.domain.userVO;

public interface IUserDao {

	void save(userVO user);

	List<userVO> get(long id);

	List<userVO> findUserByCondition(String sql);

	void updataUserById(String sql);

	List<userVO> login(String sql);

}
