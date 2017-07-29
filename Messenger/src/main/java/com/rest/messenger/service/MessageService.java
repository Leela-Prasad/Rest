package com.rest.messenger.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.rest.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		return Arrays.asList(new Message(1,"Hello World",new Date(),"Leela"),
							 new Message(2,"Hello Jersey",new Date(),"Leela"));
	}
}

