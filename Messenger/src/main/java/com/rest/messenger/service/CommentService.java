package com.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.messenger.bootstrap.MessengerBootstrap;
import com.rest.messenger.model.Comment;
import com.rest.messenger.model.Message;

public class CommentService {

	private Map<Long,Message> messages = MessengerBootstrap.getMessages();
	
	public List<Comment> getComments(Long messageId) {
		return new ArrayList<>(messages.get(messageId).getComments().values());
	}
	
	public Comment getComment(Long messageId,Long commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(Long messageId,Comment comment) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1L);
		comments.put(comment.getId(), comment);
		messages.get(messageId).setComments(comments);
		return comment;
	}
	
	public Comment updateComment(Long messageId,Comment comment) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		messages.get(messageId).setComments(comments);
		return comment;
	}
	
	public void deleteComment(Long messageId,Long commentId) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comments.remove(commentId);
		messages.get(messageId).setComments(comments);
	}
}
