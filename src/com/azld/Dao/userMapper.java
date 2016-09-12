package com.azld.Dao;

import java.util.List;

import com.azld.model.user;
import com.azld.model.userKey;

public interface userMapper {
    int deleteByPrimaryKey(userKey key);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(userKey key);

    user selectByPrimaryKeyID(userKey key);
    user selectByPrimaryKeyName(userKey key);
    
    List<user> selectUsersWithID(userKey key);
    
    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}