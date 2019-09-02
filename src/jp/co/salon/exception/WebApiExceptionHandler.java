package jp.co.salon.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApiExceptionHandler {

	public Response handleException(WebApiException e) {

		WebApiErrorResponse error = new WebApiErrorResponse();

		error.setStatus(HttpStatus.HTTP_STATUS_CODE_NOT_FOUND.getCode());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return Response.ok().entity(error).build();
	}

	public Response handleException(
			Exception e) {

		WebApiErrorResponse error = new WebApiErrorResponse();

		error.setStatus(HttpStatus.HTTP_STATUS_CODE_BAD_REQUEST.getCode());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return Response.ok().entity(error).build();
	}
}
