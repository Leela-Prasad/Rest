package com.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.rest.messenger.bootstrap.MessengerBootstrap;
import com.rest.messenger.model.Message;

public class MessageService {

	private Map<Long,Message> messages = MessengerBootstrap.getMessages();
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessages(Integer year) {
		Calendar cal = Calendar.getInstance();
		List<Message> filteredMessages = new ArrayList<>();
		messages.forEach((id,message) -> { 
			cal.setTime(message.getDateCreated());
			if(cal.get(Calendar.YEAR) == year) {
				filteredMessages.add(message);
			}
		});
		return filteredMessages;
	}
	
	public List<Message> getAllMessages(Integer start,Integer size) {
		if((start+size)>messages.size())
			return new ArrayList<>();
		return new ArrayList<>(messages.values()).subList(start, start+size);
	}
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1L);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return message;
	}
	
	public void removeMessage(Long id) {
		messages.remove(id);
	}
}

