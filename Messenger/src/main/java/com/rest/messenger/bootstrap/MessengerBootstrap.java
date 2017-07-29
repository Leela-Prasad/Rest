package com.rest.messenger.bootstrap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rest.messenger.model.Message;
import com.rest.messenger.model.Profile;

public class MessengerBootstrap {

	private static Map<Long,Message> messages = new HashMap<>();;
	private static Map<String,Profile> profiles = new HashMap<>();
	
	public MessengerBootstrap() {
		super();
	}
	
	public static Map<Long,Message> getMessages() {
		loadMessages();
		return messages;
	}
	
	public static Map<String,Profile> getProfiles() {
		loadProfiles();
		return profiles;
	}

	private static void loadMessages() {
		messages.put(1L,new Message(1,"Hello World",new Date(),"Leela"));
		messages.put(2L, new Message(2,"Hello Jersey",new Date(),"Leela"));
	}
	
	private static void loadProfiles() {
		profiles.put("leela", new Profile(1,"leela","prasad","leela"));
		profiles.put("admin", new Profile(2,"admin","user","admin"));
	}
}
