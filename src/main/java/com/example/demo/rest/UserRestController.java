package com.example.demo.rest;

import java.util.UUID;

import com.example.demo.entity.Message;
import com.example.demo.service.AuthInfoService;
import com.example.demo.service.DataBaseService;
import com.example.demo.service.MessageService;
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

	UserService userService;
	AuthInfoService authInfoService;
	MessageService messageService;

	UserRestController(UserService userService, AuthInfoService authInfoService, MessageService messageService){
		this.userService = userService;
		this.authInfoService = authInfoService;
		this.messageService = messageService;
	}


	@GetMapping("get/{id}")
	@ResponseBody
	public User get(@PathVariable("id") int userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping("add")
	@ResponseBody
	public AuthInfo add(@RequestBody User user) {
		userService.addUser(user);
		messageService.setNew(user.getUserId(),false);
		return authInfoService.addAuth(user.getUserId());
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
		User user = userService.getUser(userId);
		if(user.getPassword().equals(pass)) {
			{
				System.out.println("login ok");
				AuthInfo authInfo = authInfoService.updateAuth(userId);
				System.out.println(authInfo.toString());
				return authInfoService.updateAuth(userId).getAuthId();
			}
		}
		else
			return null;
	}
	
	@GetMapping("check")
	@ResponseBody
	public boolean check(@RequestParam("userId") int userId) {
		System.out.println(userId);
		return userService.check(userId);
	}
	
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id")int userId) {
		userService.removeUser(userId);
		return "User deleted";
	}
}
