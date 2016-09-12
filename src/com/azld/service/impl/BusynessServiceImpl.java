package com.azld.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.azld.Dao.businessMapper;
import com.azld.model.business;
import com.azld.model.businessKey;
import com.azld.service.BusynessService;


@Service("busynessService")
public class BusynessServiceImpl implements BusynessService 
{
	@Resource
	private businessMapper	abns;	
	
	private int addabusiness(Integer uid, Integer bid)
	{
		business busy = new business();
		busy.setBookid(bid);
		busy.setUserid(uid);
		busy.setType(1);
		
		abns.insert(busy);
		
		return 1;
	}
	
	@Override
	public int add(Integer uid, Integer bid)
	{
		List<business> bnlist = this.listwithbook(bid);
		if( bnlist == null || bnlist.size() == 0 )
		{
			return this.addabusiness(uid, bid);
		}
		else
		{
			business abn = bnlist.get(0);
			if( abn.getType() == 1 )
			{
				this.delete(bid);
			}
			this.addabusiness(uid, bid);
		}
		
		return 0;
	}

	@Override
	public int edit(Integer id) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<business> list(Integer uid) 
	{
		businessKey bnk = new businessKey();
		bnk.setUserid(uid);
		List<business> bnlist = this.abns.selectByPrimaryKeyUserid(bnk);
		return bnlist;
	}

	@Override
	public List<business> listwithbook(Integer bid) 
	{
		businessKey bnk = new businessKey();
		bnk.setBookid(bid);
		List<business> bnlist = this.abns.selectByPrimaryKeyBookid(bnk);
		return bnlist;
	}

	@Override
	public business getabusy(Integer uid, Integer bid)
	{
		businessKey bk = new businessKey();
		bk.setBookid(bid);
		bk.setUserid(uid);
		
		business busy = this.abns.selectByPrimaryKey(bk);
		
		return busy;
	}

	@Override
	public int update(business busy) 
	{
		if( busy.getType() != 3 )
		{
			this.abns.updateByPrimaryKey(busy);
		}
		else
		{
			this.abns.updateEndUsing(busy);
		}
		return 0;
	}

	@Override
	public business getausingbusy(Integer bid) 
	{
		business busy = new business();
		busy.setBookid(bid);
		business busy2 = this.abns.selectUsingBook(busy);
		
		return busy2;
	}
	
	
	
}
