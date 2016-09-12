package com.azld.Dao;

import java.util.List;

import com.azld.model.book;
import com.azld.model.bookKey;

public interface bookMapper {
    int deleteByPrimaryKey(bookKey key);

    int insert(book record);

    int insertSelective(book record);

    book selectByPrimaryKey(bookKey key);

    book selectByPrimaryKeyID(bookKey key);
    book selectByPrimaryKeyName(bookKey key);
    List<book> selectByPrimaryKeyDesc(bookKey key);
    
    int updateByPrimaryKeySelective(book record);

    int updateByPrimaryKey(book record);
}