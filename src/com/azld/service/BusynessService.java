package com.azld.service;

import java.util.List;

import com.azld.model.business;

public interface BusynessService {

	int	add(Integer uid, Integer bid);
	int edit(Integer id);
	int delete(Integer bid);
	
	List<business> list(Integer uid);
	List<business> listwithbook(Integer bid);
	
	business getabusy(Integer uid, Integer bid);
	business getausingbusy(Integer bid);
	
	int	update(business busy);
	
}
