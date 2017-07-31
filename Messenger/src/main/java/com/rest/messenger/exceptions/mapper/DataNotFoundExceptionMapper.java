package com.rest.messenger.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.messenger.exceptions.DataNotFoundException;
import com.rest.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage message = new ErrorMessage();
		message.setErrorCode(404);
		message.setErrorMessage(ex.getMessage());
		return Response.status(Status.NOT_FOUND)
						.entity(message)
						.build();
	}

}
