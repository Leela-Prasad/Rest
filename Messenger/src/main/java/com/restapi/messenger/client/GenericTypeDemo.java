package com.restapi.messenger.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.restapi.messenger.client.model.Message;

public class GenericTypeDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/restapi");
		WebTarget messagesTarget = baseTarget.path("/messages");
		List<Message> messages = messagesTarget.queryParam("year", 2017)
												.request(MediaType.APPLICATION_JSON)
												.get(new GenericType<List<Message>>() {});
		System.out.println(messages);
	}
}
