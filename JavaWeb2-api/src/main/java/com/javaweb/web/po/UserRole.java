package com.javaweb.web.po;

import java.io.Serializable;

import com.javaweb.interceptor.mybatis.Column;
import com.javaweb.interceptor.mybatis.Table;

@Table(name="user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = -362334579286862491L;

	@Column(name="id",pk=true)
	private String id;//主键ID
	
	@Column(name="user_id")
	private String userId;//用户ID

	@Column(name="role_id")
	private String roleId;//角色ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
