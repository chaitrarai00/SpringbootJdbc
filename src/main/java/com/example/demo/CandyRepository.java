package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	public int update_candy(Candy candy) {
		return jdbctemplate.update("update candystore set name = ?, composition = ? where id = ?", new Object[] {
			candy.getName(),
			candy.getComposition(),
			candy.getId()
		});
	}
	
	public int delete(Candy candy) {
		return jdbctemplate.update("delete from candystore where id=?",new Object[] {
		candy.getId()
	});
	}

	public Candy findbyId(int id){
		return jdbctemplate.queryForObject("select * from candystore where id=?", 
				new Object[] {
						id
				},new BeanPropertyRowMapper<Candy>(Candy.class));
	}
	
	class Candyrowmapper implements RowMapper<Candy>{

		@Override
		public Candy mapRow(ResultSet rs, int rowNum) throws SQLException {
			Candy candy=new Candy();
			candy.setId(rs.getInt("id"));
			candy.setName(rs.getString("name"));
			candy.setComposition(rs.getString(3));
			return candy;
		}
		
	}
	
	public List<Candy> findAllcandies(){
		return jdbctemplate.query("select * from candystore", new Candyrowmapper());
	}
}
