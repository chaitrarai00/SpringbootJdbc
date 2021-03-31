package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjdbcApplication implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CandyRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringjdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("inserting value---> ",repo.insert(new Candy(1,"lindt","chocolate drizzles on soft caramel")));
		
	}

}
