package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.base.BaseDao;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.eo.user.UserListResponse;
import com.javaweb.web.eo.user.UserLoginRequest;
import com.javaweb.web.po.User;

@Mapper
public interface UserDao extends BaseDao<User> {
	
	public User userLogin(UserLoginRequest userLogin);
	
	public List<UserListResponse> userList(UserListRequest userListRequest);
	
	public Long userListCount(UserListRequest userListRequest);
	
	public void userDelete(String userId);
	
	public void userAdd(User user);
	
}