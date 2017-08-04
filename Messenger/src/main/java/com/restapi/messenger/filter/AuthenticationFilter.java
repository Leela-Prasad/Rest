package com.restapi.messenger.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter{

	private static final String AUTHENTICATION_HEADER_KEY = "Authorization";
	private static final String AUTHENTICATION_KEY_PREFIX = "Basic ";
	private static final String REQUEST_URL_PREFIX="secured";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> keys = requestContext.getHeaders().get(AUTHENTICATION_HEADER_KEY);
		if(requestContext.getUriInfo().getPath().contains(REQUEST_URL_PREFIX)) {
			if(null!=keys && keys.size()>0) {
				String encodedKey = keys.get(0).replace(AUTHENTICATION_KEY_PREFIX,"");
				String authenticationKey = Base64.decodeAsString(encodedKey);
				StringTokenizer tokenizer = new StringTokenizer(authenticationKey, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if("user".equals(username) && "password".equals(password)) {
					return; 
				}
				
			}
			Response response = Response.status(Status.UNAUTHORIZED)
					.entity("User is NOT authorized")
					.type(MediaType.TEXT_PLAIN)
					.build();
			requestContext.abortWith(response);
					
		}
	}

}
