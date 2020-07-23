package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "message")
@Table(name = "message")
public class Message {

	@Column(name = "message")
	String message;
	@Column(name = "send_time")
	long sendtime;
	@Column(name = "rec_time")
	long recTime;
	@Column(name = "seen_time")
	long seenTime;
	@Id
	@Column(name = "message_id")
	int messageId;
	@Column(name = "sender_id")
	int senderId;
	@Column(name = "recevier_id")
	int recevierId;

	public Message() {
	}

	public Message(String message, long sendtime, int messageId, int senderId, int recevierId) {
		this.message = message;
		this.sendtime = sendtime;
		this.messageId = messageId;
		this.senderId = senderId;
		this.recevierId = recevierId;
	}

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

	public Message(String message, long sendtime, long recTime, long seenTime, int messageId, int senderId, int recevierId) {
		this.message = message;
		this.sendtime = sendtime;
		this.recTime = recTime;
		this.seenTime = seenTime;
		this.messageId = messageId;
		this.senderId = senderId;
		this.recevierId = recevierId;
	}

	@Override
	public String toString() {
		return "Message{" +
				"message='" + message + '\'' +
				", sendtime=" + sendtime +
				", recTime=" + recTime +
				", seenTime=" + seenTime +
				", messageId=" + messageId +
				", senderId=" + senderId +
				", recevierId=" + recevierId +
				'}';
	}
}
