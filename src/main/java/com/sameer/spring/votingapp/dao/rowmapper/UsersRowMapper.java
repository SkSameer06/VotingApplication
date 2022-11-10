package com.sameer.spring.votingapp.dao.rowmapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sameer.spring.votingapp.entities.Users;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setEmail(rs.getString(4));
		user.setPnum(rs.getString(5));
		user.setStatus(rs.getString(6));
		user.setVotedTo(rs.getString(7));
		return user;
	}
	

}
