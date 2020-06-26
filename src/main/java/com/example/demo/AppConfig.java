package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.MessageController;
import com.example.demo.controller.UserController;

@Configuration
public class AppConfig {

	@Bean
	UserController userController() {
		return new UserController();
	}
	@Bean
	MessageController messageController() {
		return new MessageController();
	}
}
