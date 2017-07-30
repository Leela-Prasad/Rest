package com.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.messenger.beans.MessageResourceBean;
import com.rest.messenger.model.Message;
import com.rest.messenger.service.MessageService;


@Path("/messages")
public class MessengerResource {

	MessageService service = new MessageService();
	
	/**
	 * 
	 * @param messageBean
	 * @return
	 * Bean Param is used when we have multiple params and
	 * getting these params using annotations as method arguments
	 * will be messy. so we will define a bean with the param and 
	 * inject that bean using BeanParam Annotation. so that we
	 * can take required parameters in our logic
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam MessageResourceBean messageBean) {
		if(messageBean.getYear()!=null)
			return service.getAllMessages(messageBean.getYear());
		else if(messageBean.getStart()!=null && messageBean.getSize()!=null)
			return service.getAllMessages(messageBean.getStart(), messageBean.getSize());
		
			return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long id) {
		return service.getMessage(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return service.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long id,Message message) {
		message.setId(id);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") Long id) {
		service.removeMessage(id);
	}
	
	
}
