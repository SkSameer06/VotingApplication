package com.sameer.spring.votingapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sameer.spring.votingapp.dao.UserDao;
import com.sameer.spring.votingapp.dao.resultDao;
import com.sameer.spring.votingapp.entities.Users;
import com.sameer.spring.votingapp.entities.result;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	//@Qualifier("dao")
	private UserDao dao;
	
	@Autowired(required = true)
	private resultDao resdao;

	@Override
	public int save(Users users) {

		return getDao().create(users);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public Users loginCheck(String username, String password) {
		
		return dao.loginCheck(username, password);
	}

	@Override
	public int updateStatus(String username) {
		
		return dao.update(username);
	}

	@Override
	public Users readStatusofvote(String username, String password) {
		
		return dao.readStatus(username, password);
	}

	@Override
	public List<result> findAll(result res) {
		
		return resdao.readAll(res);
	}

	@Override
	public int updateResult(String name,int count) {
		
		return resdao.resUpdate(name, count);
	}

	@Override
	public Users adminloginCheck(String username, String password) {
		
		return dao.loginCheckAdmin(username, password);
	}

	@Override
	public int updateVoteResult(String name, String voteTo) {
		
		return dao.updateVote(name, voteTo);
	}

	@Override
	public Users readVoteTo(String username, String password) {
		
		return dao.readVote(username, password);
	}

}
