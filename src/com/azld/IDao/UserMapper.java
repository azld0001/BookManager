package com.azld.IDao;

import java.util.List;

import com.azld.model.User;
import com.azld.model.UserKey;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);
    User selectByPrimaryKeyID(UserKey key);
    User selectByPrimaryKeyName(UserKey key);
    
    List<User> selectUserList(UserKey key);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}