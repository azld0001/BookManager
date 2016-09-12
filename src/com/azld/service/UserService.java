package com.azld.service;

import java.util.List;

import com.azld.model.user;

public interface UserService 
{
	int add(user u);
	
	int delete(Integer uid);
	
	int	edit(user u);
	
	user getwithid(Integer uid);
	user getwithname(String uname);
	
	List<user> list(Integer uid);
}
