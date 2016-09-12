package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.azld.model.user;
import com.azld.service.UserService;

//import com.azld.model.User;
//import com.azld.model.UserKey;
//import com.azld.service.UserService;
//import com.azld.IDao.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring.xml"})  

public class UserServiceTest 
{
	@Resource
	private UserService aus;

	public void userget()
	{
		List<user> userlist = aus.list(0);
		
		for ( user u:userlist )
		{
			showuserinfo(u);
		}
	}
	
	public List<user> getusers()
	{
		List<user> userlist = aus.list(0);
		return userlist;
	}
	
	public void showuserinfo(user u)
	{
		System.out.println("userid:"+u.getId()+"username:"+u.getName());
	}
	
	@Test
	public void deluser()
	{
		user au = aus.getwithid(1);
		if( au != null )
		{
			aus.delete(au.getId());
		}
		
		user bu = aus.getwithid(au.getId());
		if( bu == null )
		{
			System.out.println("user have delete");
		}
	}
	
	@Test
	public void getuser()
	{
		List<user> users = this.getusers();
		
		for( user u:users )
		{
			user au = aus.getwithid(u.getId());
			user bu = aus.getwithname(u.getName());
			
			showuserinfo(au);
			showuserinfo(bu);
		}

	}
	
	@Test
	public void useredit()
	{
		List<user> users = this.getusers();
		for( user u:users )
		{
			u.setPassword(u.getName());
			aus.edit(u);
		}
	}
	
	@Test
	public void useradd()
	{
		user u = new user();
		u.setName("user005");
		u.setPassword(u.getName()+u.getName());
		u.setTitle(1);
		aus.add(u);
		
		userget();
	}
	
}
