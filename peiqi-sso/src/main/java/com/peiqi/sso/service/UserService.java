package com.peiqi.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiqi.commons.pojo.user.User;
import com.peiqi.sso.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void register(User user) {
		userMapper.register(user);
	}

	public User login(User user) {
		return userMapper.login(user);
	}
	
}
