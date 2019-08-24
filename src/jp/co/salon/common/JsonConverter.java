package jp.co.salon.common;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import net.arnx.jsonic.JSON;

@Provider()
@Produces(MediaType.APPLICATION_JSON)
public class JsonConverter implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object object, Class<?> arg1, Type genericType,
		Annotation[] annotation, MediaType mediaType) {

		try {
			return JSON.encode(object).getBytes("UTF-8").length;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isWriteable(Class<?> entity, Type genericType,
		Annotation[] annotation, MediaType mediaType) {

		return mediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE);
	}

	@Override
	public void writeTo(Object object, Class<?> arg1, Type genericType,
    	Annotation[] annotation, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
    	OutputStream entityStream) throws IOException, WebApplicationException {

    	JSON.encode(object, entityStream);
    }
}
