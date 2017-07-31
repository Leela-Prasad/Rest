package com.rest.messenger.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage message = new ErrorMessage();
		message.setErrorCode(500);
		message.setErrorMessage(ex.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(message)
						.build();
	}

}
