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
		logger.info("inserting value---> ",repo.insert(new Candy(2,"ferrero rocher","hazelnut covered with thick dark chocolate inside a wafer cover drizzled upon by belgium chocolate and broken roasted nuts")));
		logger.info("inserting value---> ",repo.insert(new Candy(3,"blue ocean","crystal mints on top of dark chocolate cubes topped over a layer of belgium chocolate")));
		logger.info("updating values---> ",repo.update_candy(new Candy(1,"caramalizing shots","soft caramel center covered with thick hard dark chocolate which surrounding layer of belgium chocolate")));
		logger.info("inserting values--->",repo.insert(new Candy(4,"truffle","chocolate ganache centre coated in chocolate, icing sugar, cocoa powder or chopped toasted nuts")));
		logger.info("inserting values---> ",repo.insert(new Candy(5,"Cuberdon","cone-shaped candy with a melty core and a crisp crust is flavored with raspberry")));
		logger.info("deleting values---> ",repo.delete(new Candy(5)));
		logger.info("finding all values---> ");
		System.out.println(repo.findAllcandies());
	}

}
