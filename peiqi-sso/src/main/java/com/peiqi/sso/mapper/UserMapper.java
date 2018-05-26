package com.peiqi.sso.mapper;

import com.peiqi.commons.pojo.user.User;

public interface UserMapper {

	public void register(User user);

	public User login(User user);
	
}
