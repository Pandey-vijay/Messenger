package com.example.demo.rest;

import java.util.UUID;

import com.example.demo.service.AuthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthInfo;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserRestController {

	@Autowired
	UserService userService;
	@Autowired
	AuthInfoService authInfoService;
	
	int userCount = 0;
	
	@GetMapping("get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("add")
	@ResponseBody
	public AuthInfo add(@RequestBody User user) {
		long lastSeen = System.currentTimeMillis();
		user.setUserId(userCount);
		userCount++;
		userService.addUser(user);
		userService.updateLastSeen(user.getUserId(), lastSeen);
		return authInfoService.addAuth(user.getUserId(),UUID.randomUUID());
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
	
	@GetMapping("login")
	@ResponseBody
	public UUID login(@RequestParam("userId") int userId, @RequestParam("pass") String pass) {
		if(userService.getUser(userId).getPass().equals(pass)) {
			UUID authId  = UUID.randomUUID();
			authInfoService.addAuth(userId, authId);
			return authId;
		}
		else {
			return null;
		}
	}
	
	@GetMapping("check")
	@ResponseBody
	public boolean check(@RequestParam("userId") int userId,@RequestParam("authId") UUID authId) {
		return authInfoService.checkAuth(userId,authId);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id")int userId) {
		userService.removeUser(userId);
		return "User deleted";
	}
}
