package com.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="link")
public class Link {

	private String link;
	private String rel;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
