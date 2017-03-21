package com.javaweb.dataobject.po;

import java.io.Serializable;

import com.javaweb.base.BaseEntity;

public class User extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6510578701541824368L;

	private String userId;//用户id,主键(必填)
	
	private String userName;//用户名(必填)
	
	private String password;//用户密码(必填)
	
	private String personName = null;//用户姓名

	private String email = null;//电子邮箱
	
	private String phone = null;//手机号码
	
	private String portrait = null;//头像
	
	private String parentId = null;//创建该用户的id
	
	private String fcode = null;//层级关系
	
	private int level = 0;//第几级(0表示未定义层级数;层级数1为最高,即根节点)

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
