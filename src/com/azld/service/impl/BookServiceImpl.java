package com.azld.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.azld.Dao.bookMapper;
import com.azld.model.book;
import com.azld.model.bookKey;
import com.azld.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private bookMapper bookmapper;
	
	@Override
	public int add(book b) 
	{// 0:成功  1:已存在该用户名的用户
		book ab = this.getwithname(b.getName());
		if( ab == null )
		{
			this.bookmapper.insert(b);
			return 0;
		}
		return 1;
	}

	@Override
	public int delete(Integer bid) 
	{
		int iret = 1;
		book ab = this.getwithid(bid);
		if( ab == null )
		{
			return iret;
		}
		bookKey bk = new bookKey();
		bk.setId(bid);
		this.bookmapper.deleteByPrimaryKey(bk);
		return 0;
	}

	@Override
	public int edit(book b)
	{
		book ab = this.getwithid(b.getId());
		if( ab == null )
		{
			return 1;
		}
		
		this.bookmapper.updateByPrimaryKey(b);
		return 0;
	}

	@Override
	public book getwithid(Integer bid) 
	{
		bookKey bk = new bookKey();
		bk.setId(bid);
		book b = this.bookmapper.selectByPrimaryKeyID(bk);
		return b;
	}

	@Override
	public book getwithname(String bname) 
	{
		bookKey bk = new bookKey();
		bk.setName(bname);
		book b = this.bookmapper.selectByPrimaryKeyName(bk);
		return b;
	}

	@Override
	public List<book> list(String bname) 
	{
		bookKey bk = new bookKey();
		bk.setName(bname);
		List<book> booklist = this.bookmapper.selectByPrimaryKeyDesc(bk);
		return booklist;
	}

}
