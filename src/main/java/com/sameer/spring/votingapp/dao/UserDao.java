package com.sameer.spring.votingapp.dao;
import com.sameer.spring.votingapp.entities.Users;

public interface UserDao {
	
	int create(Users users);
	
	Users loginCheck(String username,String password);
	
	Users loginCheckAdmin(String username, String password);
	
	int update(String username);
	
	Users readStatus(String username, String password);
	
	int updateVote(String username,String votedTo);
	
	Users readVote(String name, String password);
	

}
