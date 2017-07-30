package com.rest.messenger.resource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
