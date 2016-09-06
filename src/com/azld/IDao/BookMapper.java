package com.azld.IDao;

import com.azld.model.Book;
import com.azld.model.BookKey;

public interface BookMapper {
    int deleteByPrimaryKey(BookKey key);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(BookKey key);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}