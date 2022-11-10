package com.sameer.spring.votingapp.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sameer.spring.votingapp.dao.resultDao;
import com.sameer.spring.votingapp.entities.result;
import com.sameer.spring.votingapp.dao.rowmapper.ResultRowMapper;

@Repository
@Component("resultDao")
public class resultDaoImpl implements resultDao {

	@Autowired(required = true)
	JdbcTemplate jdbcTemplate;

	@Override
	public List<result> readAll(result res) {
		//String sql = "select * from result";
		String sql = "select votedTo, count(votedTo) from users group by votedTo";
		ResultRowMapper rowmapper = new ResultRowMapper();
		List<result> result = jdbcTemplate.query(sql, rowmapper);
		return result;

	}

	@Override
	public int resUpdate(String name,int count) {
		String sql = "update result set count=? where name=?";
		int result = jdbcTemplate.update(sql, count,name);
		return result;

	}
	
	

}
