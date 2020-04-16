package com.hemaobin.webDemo.atom.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hemaobin.webDemo.atom.interfaces.IUserDao;
import com.hemaobin.webDemo.domain.userVO;

public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

	@Override
	public void save(userVO user) {
		getJdbcTemplate().update("insert into user(email,psw,username,sex,tel,address,age,status)values(?,?,?,?,?,?,?,?)",user.getEmail(),user.getPsw(),user.getUserName(),user.getSex(),user.getTel(),user.getAddress(),user.getAge(),1);
	
	}

	@Override
	public List<userVO> get(long id) {
		List<userVO> userVOs=getJdbcTemplate().query("select * from user where 1=1 and userid=?", new BeanPropertyRowMapper<userVO>(userVO.class), id);
		return userVOs;
	}

	@Override
	public List<userVO> findUserByCondition(String sql) {
		List<userVO> userVOs=getJdbcTemplate().query(sql,new BeanPropertyRowMapper<userVO>(userVO.class));
		return userVOs;
	}

	@Override
	public void updataUserById(String sql) {
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List<userVO> login(String sql) {
		List<userVO> userVOs=getJdbcTemplate().query(sql,new BeanPropertyRowMapper<userVO>(userVO.class));
		return userVOs;
	}

}
