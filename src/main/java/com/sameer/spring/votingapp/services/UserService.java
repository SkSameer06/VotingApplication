package com.sameer.spring.votingapp.services;

import java.util.List;


import com.sameer.spring.votingapp.entities.Users;
import com.sameer.spring.votingapp.entities.result;

public interface UserService {
	
	int updateResult(String name,int count);
	
	int save(Users users);

	Users loginCheck(String username,String password);
	
	Users adminloginCheck(String username,String password);
	
	int updateStatus(String username);
	
	Users readStatusofvote(String username,String password);
	
	List<result> findAll(result res);
	
	int updateVoteResult(String name,String voteTo);
	
	Users readVoteTo(String username,String password);



}
