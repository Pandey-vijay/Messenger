package com.example.demo.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping("message")
public class MessageRestController {
	@Autowired
	MessageService messageService;
	
	@GetMapping("get/{id}")
	@ResponseBody
	public Map<Integer, Message> get(@PathVariable("id")int userId){
		return messageService.getAllMessage(userId);
	}
	
	@PostMapping("send")
	public String send(@RequestBody Message message) {
		messageService.addMessage(message);
		return "Message Send";
	}
	

}
