package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	DataBaseService dataBaseService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

