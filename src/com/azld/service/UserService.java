package com.azld.service;

import java.util.List;

import com.azld.model.User;

public interface UserService 
{
	public User getuserwithPK(User auser);
	
	public User getuserwithuid(Integer uid);
	
	public User add(User auser);
	public Integer delete(User auser);
	public User login(User auser);
	public List<User> list(Integer id);
	
	
}
