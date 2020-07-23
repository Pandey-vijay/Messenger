package com.example.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Message;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping("message")
@CrossOrigin("*")
public class MessageRestController {

	MessageService messageService;

	MessageRestController(MessageService messageService){
		this.messageService = messageService;
	}

	@GetMapping("get/{id}")
	@ResponseBody
	public List<Message> get(@PathVariable("id")int userId){
		try{
			if(messageService.getNew(userId)) {
				messageService.setNew(userId,false);
				return messageService.getAllMessage(userId);
			}
			else
				return null;
		}
		catch (Exception e){
			System.out.println(userId);
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("send")
	@ResponseBody
	public boolean send(@RequestBody Message message) {
		messageService.setNew(message.getRecevierId(),true);
		messageService.addMessage(message);
		System.out.println(message);
		return true;
	}
	

}
