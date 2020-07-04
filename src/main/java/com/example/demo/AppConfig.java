package com.example.demo;

import com.example.demo.controller.AuthInfoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.MessageController;
import com.example.demo.controller.UserController;
import com.example.demo.entity.AuthInfo;

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
	@Bean
	AuthInfoController authInfoController() {
		return new AuthInfoController();
	}

}
