package com.example.demo.entity;

public class Message {

	String message;
	long sendtime,recTime,seenTime;
	int messageId,senderId,recevierId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getSendtime() {
		return sendtime;
	}
	public void setSendtime(long sendtime) {
		this.sendtime = sendtime;
	}
	public long getRecTime() {
		return recTime;
	}
	public void setRecTime(long recTime) {
		this.recTime = recTime;
	}
	public long getSeenTime() {
		return seenTime;
	}
	public void setSeenTime(long seenTime) {
		this.seenTime = seenTime;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getRecevierId() {
		return recevierId;
	}
	public void setRecevierId(int recevierId) {
		this.recevierId = recevierId;
	}
	
	

}
