package com.azld.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.azld.Dao.userMapper;
import com.azld.model.user;
import com.azld.model.userKey;
import com.azld.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService 
{
	@Resource
	private userMapper		usermaper;
	
	@Override
	public int add(user u)
	{ // 0:成功  1:已存在该用户名的用户
		user au = this.getwithname(u.getName());
		if( au == null )
		{
			this.usermaper.insert(u);
			return 0;
		}
		return 1;
	}

	@Override
	public int delete(Integer uid) 
	{// 0 成功  1:无此用户
		int iret = 1;
		user au = this.getwithid(uid);
		if( au == null )
		{
			return iret;
		}
		userKey uk = new userKey();
		uk.setId(uid);
		this.usermaper.deleteByPrimaryKey(uk);
		return 0;
	}

	@Override
	public int edit(user u) 
	{
		user au = this.getwithid(u.getId());
		if( au == null )
		{
			return 1;
		}
		
		this.usermaper.updateByPrimaryKey(u);
		
		return 0;
	}

	@Override
	public user getwithid(Integer uid) 
	{
		userKey uk = new userKey();
		uk.setId(uid);
		user au = this.usermaper.selectByPrimaryKeyID(uk);
		return au;
	}

	@Override
	public user getwithname(String uname) 
	{
		userKey uk = new userKey();
		uk.setName(uname);
		user au = this.usermaper.selectByPrimaryKeyName(uk);
		return au;
	}
	
	@Override
	public List<user> list(Integer uid)
	{
		userKey uk = new userKey();
		uk.setId(uid);
		List<user> userlist = this.usermaper.selectUsersWithID(uk);
		return userlist;
	}
}
