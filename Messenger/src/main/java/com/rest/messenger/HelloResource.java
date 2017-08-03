package com.rest.messenger;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Singleton
@Path("/hello")
public class HelloResource {

	private int count;
	
	@GET
	@Path("/{name}")
	public String greet(@PathParam("name") String name) {
		count=count + 1;
		return "Hello " + name + "Count : " + count;
	}
	
}
