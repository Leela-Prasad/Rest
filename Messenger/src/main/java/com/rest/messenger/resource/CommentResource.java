package com.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.messenger.model.Comment;
import com.rest.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService service = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") Long messageId) {
		return service.getComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId) {
		return service.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") Long messageId,Comment comment) {
		return service.addComment(messageId, comment);
	}
	
	@PUT
	public Comment updateComment(@PathParam("messageId") Long messageId,Comment comment) {
		return service.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId) {
		service.deleteComment(messageId, commentId);
	}
	
}
