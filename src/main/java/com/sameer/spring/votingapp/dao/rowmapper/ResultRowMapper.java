package com.sameer.spring.votingapp.dao.rowmapper;

import java.sql.ResultSet;


import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sameer.spring.votingapp.entities.result;

public class ResultRowMapper implements RowMapper<result> {

	@Override
	public result mapRow(ResultSet rs, int rowNum) throws SQLException {
		result res = new result();
		res.setName(rs.getString(1));
		res.setCount(rs.getInt(2));
		return res;
	}
	

}



