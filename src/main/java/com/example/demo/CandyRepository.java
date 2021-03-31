package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CandyRepository {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public int insert(Candy candy) {
		return jdbctemplate.update("insert into candystore (id, name, composition) values(?, ? ,?)",
				new Object[] {
						candy.getId(), 
						candy.getName(), 
						candy.getComposition()
						}
		);
	}
}
