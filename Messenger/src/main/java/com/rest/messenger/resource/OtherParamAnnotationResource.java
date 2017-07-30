package com.rest.messenger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectparams")
public class OtherParamAnnotationResource {

	/**
	 * 
	 * @param matrixParam
	 * @return
	 * Matrix Param is passed by using ";" symbol
	 * @CookieParam and @FormParam is also there
	 * to access cookie values and form values
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@MatrixParam("param") String matrixParam,
			@HeaderParam("sessionId") String sessionId) {
		return "Matrix Param : " + matrixParam + " Header param : " + sessionId;
	}
	
	/**
	 * 
	 * @param uriInfo
	 * @param headers
	 * @return
	 * 
	 * we can use context Annotations to inject special
	 * objects like UriInfo,HTTPHeaders so that we can 
	 * get all the request related information and header
	 * level information
	 */
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String testContextParams(@Context UriInfo uriInfo,@Context HttpHeaders headers) {	
		return uriInfo.getAbsolutePath().toString()
				+ "\t" + uriInfo.getBaseUri().toString()
				+ "\t" + uriInfo.getQueryParameters().toString()
				+ "\t" + headers.getRequestHeaders().toString()
				+ "\t" + headers.getCookies();
				
	}
}
