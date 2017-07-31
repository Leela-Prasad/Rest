package com.rest.messenger.model;

import java.util.Date;

public class Comment {

	private Long id;
	private String message;
	private String author;
	private Date dateCreated;
	
	public Comment() {
		super();
	}
	
	public Comment(Long id, String message, String author, Date dateCreated) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
