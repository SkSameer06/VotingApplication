package com.sameer.spring.votingapp.dao;

import java.util.List;


import com.sameer.spring.votingapp.entities.result;

public interface resultDao {
	
	int resUpdate(String name, int count);
	
	List<result> readAll(result res);
	
	

}
