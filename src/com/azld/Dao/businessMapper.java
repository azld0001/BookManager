package com.azld.Dao;

import java.util.List;

import com.azld.model.business;
import com.azld.model.businessKey;

public interface businessMapper {
    int deleteByPrimaryKey(businessKey key);

    int insert(business record);

    int insertSelective(business record);

    business selectByPrimaryKey(businessKey key);

    List<business> selectByPrimaryKeyUserid(businessKey key);
    List<business> selectByPrimaryKeyBookid(businessKey key);
    
    int updateByPrimaryKeySelective(business record);

    int updateByPrimaryKey(business record);
    int updateEndUsing(business record);
    
    business selectUsingBook(business busy);
    
    
}