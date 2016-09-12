package com.azld.service;

import java.util.List;

import com.azld.model.book;

public interface BookService 
{
	int add(book b);
	int delete(Integer bid);
	int edit(book b);
	
	book getwithid(Integer bid);
	book getwithname(String bname);
	
	List<book> list(String bname);
}
