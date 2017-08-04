package com.restapi.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.restapi.messenger.client.model.Message;

public class MessengerClient {

	public static void main(String[] args) {
		
		/*Client client = ClientBuilder.newClient();
		
		Response response = client.target("http://localhost:8080/messenger/restapi/messages/3")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		System.out.println(response.readEntity(Message.class));*/
		
		
		/*Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/restapi");
		WebTarget messagesTarget = baseTarget.path("/messages");
		Message message = messagesTarget.path("2")
						.request(MediaType.APPLICATION_JSON)
						.get(Message.class);
		
		System.out.println(message);*/
		
		
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/restapi");
		WebTarget messagesTarget = baseTarget.path("/messages");
		WebTarget messageTarget = messagesTarget.path("{messageId}");
		
		Message message1 = messageTarget.resolveTemplate("messageId","1")
										.request(MediaType.APPLICATION_JSON)
										.get(Message.class);
		
		Message message2 = messageTarget.resolveTemplate("messageId","2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		
		System.out.println(message1);
		System.out.println(message2);
		
		Message newMessage = messagesTarget.request(MediaType.APPLICATION_JSON)
											.post(Entity.json(new Message("New Message","Leela")))
											.readEntity(Message.class);
		System.out.println(newMessage);
	}
}
