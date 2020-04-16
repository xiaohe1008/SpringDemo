package com.hemaobin.webDemo.domain;

import java.io.Serializable;

/**
 * 用户信息
 * @author hemb
 * @date   2019年9月14日
 */

public class userVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private long userId;
	
	/**
	 * 用户姓名
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String psw;
	
	/**
	 * 账号状态
	 */
	private int status;
	
	/**
	 * 账号状态翻译
	 */
	private String statusDesc;
	
	/**
	 * 用户年龄
	 */
	private int age;
	
	/**
	 * 用户性别
	 */
	private String sex;
	
	/**
	 * 用户邮箱
	 */
	private String email;
	
	/**
	 * 用户电话
	 */
	private String tel;
	
	/**
	 * 用户地址
	 */
	private String address;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "userVO [userId=" + userId + ", userName=" + userName + ", psw=" + psw + ", status=" + status
				+ ", statusDesc=" + statusDesc + ", age=" + age + ", sex=" + sex + ", email=" + email + ", tel=" + tel
				+ ", address=" + address + "]";
	}
}