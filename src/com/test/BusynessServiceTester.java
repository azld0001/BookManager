package com.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.azld.model.book;
import com.azld.model.user;
import com.azld.service.BookService;
import com.azld.service.BusynessService;
import com.azld.service.UserService;
import com.azld.model.businessKey;
import com.azld.model.business;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring.xml"})  


public class BusynessServiceTester 
{
	@Resource
	private BusynessService abusys;
	
	@Resource
	private UserService aus;
	
	@Resource
	private BookService abs;
	
	private void showbusynessinfo(business abusy)
	{
		System.out.println("id:"+abusy.getId()+"book:"+abusy.getBookid()+"user:"+abusy.getUserid()+"type:"+abusy.getType() );
	}
	
	@Test
	public void addbusiness()
	{
		user au = aus.getwithname("user003");
		book ab = abs.getwithname("book004");
		
		businessKey busykey = new businessKey();
		busykey.setBookid(ab.getId());
		busykey.setUserid(au.getId());
		
		abusys.add(busykey.getUserid(), busykey.getBookid());
		
		this.listwithuser();
	}
	
	@Test
	public void edit_end()
	{
		book ab = abs.getwithname("book003");
		business busy = this.abusys.getausingbusy(ab.getId());
		if( busy.getType() != 3 )
		{
			busy.setType(3);
		}
		
		this.abusys.update(busy);
	}
	
	
	@Test
	public void edit_follow()
	{
		user au = aus.getwithname("user003");
		book ab = abs.getwithname("book003");

		business busy = this.abusys.getabusy(au.getId(), ab.getId());
		if( busy.getType() == 1 )
		{
			busy.setType(2);
		}
		this.abusys.update(busy);
		this.showbusynessinfo(busy);
	}
	
	
//	@Test
	public void listwithuser()
	{
		user au = aus.getwithname("user003");

		List<business> busylist = this.abusys.list(au.getId());
		
		for( business abusy : busylist )
		{
			this.showbusynessinfo(abusy);
		}
	}
	
	@Test
	public void listwithbook()
	{
		List<business> busylist = this.abusys.listwithbook(1);
		
		for( business abusy : busylist )
		{
			this.showbusynessinfo(abusy);
		}
	}
 	
	
	
}
