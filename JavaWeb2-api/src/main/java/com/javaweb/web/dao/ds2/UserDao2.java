package com.javaweb.web.dao.ds2;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.web.po.User;

@Mapper
public interface UserDao2 {
	
	public User getUserByUsernameAndPassword(Map<String,String> map);
	
}