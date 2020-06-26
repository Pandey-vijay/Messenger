package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Autowired
	UserService userService;
	
	@GetMapping("get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("add")
	public String add(@RequestBody User user) {
		long lastSeen = System.currentTimeMillis();
		userService.addUser(user);
		userService.updateLastSeen(user.getUserId(), lastSeen);
		return "User added  !!!!";
	}
	
	@PostMapping("update/username/{id}")
	public String updateUserName(@PathVariable("id")int userId,@RequestParam("userName")String userName) {
		userService.updateUserName(userId, userName);
		return "User Name Updates";
	}
	
	@PostMapping("update/status/{id}")
	public String updateStatus(@PathVariable("id")int userId,@RequestParam("status")String status) {
		userService.updateStatus(userId, status);
		return "User Status Updates";
	}
	
	@PostMapping("update/password/{id}")
	public String updatePassword(@PathVariable("id")int userId,@RequestParam("password")String pass) {
		userService.updatePassword(userId, pass);;
		return "User Password Updates";
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id")int userId) {
		userService.removeUser(userId);
		return "User deleted";
	}
}
