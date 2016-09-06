package com.azld.service.impl;

import java.util.List;

import com.azld.model.User;
import com.azld.model.UserKey;
import com.azld.service.UserService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.azld.IDao.UserMapper;

@Service("UserService")
//@Service
//@Autowired("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private	UserMapper		aUserMapper;
	
	@Override
	public User getuserwithPK(User auser)
	{
		UserKey usekey = new UserKey();
		usekey.setName(auser.getName());
		
		return aUserMapper.selectByPrimaryKey(usekey);
//		return aUserMapper.selectByPrimaryKey(auser);
	}
	
	@Override
	public User getuserwithuid(Integer uid)
	{
		UserKey usekey = new UserKey();
		usekey.setId(uid);
		
		return aUserMapper.selectByPrimaryKeyID(usekey);
	}
	
	@Override
	public User add(User auser)
	{
		UserKey uk = new UserKey();
		uk.setName(auser.getName());
		User buser = this.aUserMapper.selectByPrimaryKeyName(uk);
		if( buser == null )
		{
			this.aUserMapper.insert(auser);
			User cuser = this.aUserMapper.selectByPrimaryKeyName(uk);
			auser.setId(cuser.getId());
			return auser;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Integer delete(User auser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(User auser) {
		
		UserKey uk = new UserKey();
		uk.setName(auser.getName());
		User buser = this.aUserMapper.selectByPrimaryKeyName(uk);
		if( buser == null )
		{
			return buser;
		}
		else
		{
			if( auser.getName().equals(buser.getName()) == true)
			{
				return buser;
			}
			else
			{
				return null;
			}
		}
	}

	@Override
	public List<User> list(Integer id) {
		UserKey uk = new UserKey();
		uk.setId(id);
		List<User> alist = this.aUserMapper.selectUserList(uk);
		return alist;
	}
		
}
