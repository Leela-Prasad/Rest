package com.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.messenger.model.Message;
import com.rest.messenger.service.MessageService;


@Path("messages")
public class MessengerResource {

	MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return service.getAllMessages();
	}
	
}
