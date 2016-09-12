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



@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring.xml"})  

public class BookServiceTester
{
	@Resource
	private BookService abs;

	public List<book> getbooks()
	{
		List<book> booklist = abs.list("ook");
		return booklist;
	}
	
	public void showuserinfo(book b)
	{
		System.out.println("bookid:"+b.getId()+"bookname:"+b.getName());
	}

	@Test
	public void bookdelete()
	{
		book ab = this.abs.getwithname("book001");
		book bb = this.abs.getwithid(ab.getId());
		this.abs.delete(bb.getId());
	}
	
	@Test
	public void booksearch()
	{
		List<book> books = this.getbooks();
		for( book b:books )
		{
			this.showuserinfo(b);
		}
	}
	
	@Test
	public void bookedit()
	{
		List<book> books = this.getbooks();
		for( book b:books )
		{
			b.setWriter(b.getName()+"001");
			abs.edit(b);
		}
	}

	@Test
	public void bookadd()
	{
		book b = new book();
		b.setName("book008");
		b.setDescription(b.getName()+"description");
		this.abs.add(b);
	}

	
}
