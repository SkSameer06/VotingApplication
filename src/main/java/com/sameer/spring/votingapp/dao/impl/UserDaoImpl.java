package com.sameer.spring.votingapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sameer.spring.votingapp.dao.UserDao;
import com.sameer.spring.votingapp.entities.Users;
import com.sameer.spring.votingapp.dao.rowmapper.UsersRowMapper;


@Repository
@Component("userDao")
public class UserDaoImpl implements UserDao {

	
	@Autowired(required=true)
	JdbcTemplate jdbcTemplate;

	@Override
	public int create(Users users) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql,users.getId(), users.getUsername(), users.getPassword(), users.getEmail(),users.getPnum(),null,null);
		return result;
		
	}

	@Override
	public Users loginCheck(String username, String password) {
		String sql="select * from users where username=? and password=?";
		UsersRowMapper rm= new UsersRowMapper();
		Users user = jdbcTemplate.queryForObject(sql, rm, username,password);
		return user;
	}

	@Override
	public int update(String username) {
		String sql="update users set status='Voted' where username=?";
		int update = jdbcTemplate.update(sql, username);
		return update;
	}

	@Override
	public Users readStatus(String username, String password) {
		String sql="select * from users where username=? and password=?";
		UsersRowMapper rm= new UsersRowMapper();
		return null;
	}

	@Override
	public Users loginCheckAdmin(String username, String password) {
		String sql="select * from users where username='admin' and password='admin'";
		UsersRowMapper rm= new UsersRowMapper();
		Users user = jdbcTemplate.queryForObject(sql, rm, username,password);
		return user;
	}

	@Override
	public int updateVote(String username,String votedTo) {
		String sql="update users set votedTo=? where username=?";
		int updateVote = jdbcTemplate.update(sql, votedTo,username);
		return updateVote;
		
	}

	@Override
	public Users readVote(String name, String password) {
		String sql="select * from users where username=? and password=?";
		UsersRowMapper rm= new UsersRowMapper();
		Users user = jdbcTemplate.queryForObject(sql, rm, name,password);
		return user;
	}

}
