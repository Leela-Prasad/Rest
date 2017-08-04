package com.restapi.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restapi.messenger.client.model.Message;

public class InvocationDemo {
	
	public static void main(String[] args) {
		Invocation invocation = prepareRequest();
		Response response = invocation.invoke();
		Message message = response.readEntity(Message.class);
		System.out.println(message);
	}

	private static Invocation prepareRequest() {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/restapi");
		WebTarget messagesTarget = baseTarget.path("/messages");
		WebTarget messageTarget = messagesTarget.path("{messageId}");
		
		return messageTarget.resolveTemplate("messageId","1")
										.request(MediaType.APPLICATION_JSON)
										.buildGet();
		
	}
	
	

}
