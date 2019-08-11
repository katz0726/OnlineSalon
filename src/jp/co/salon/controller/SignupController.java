package jp.co.salon.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

@Path("/")
public class SignupController {
    @GET
    @Path("/signup")
    @Template(name="/html/signup")
    public String index() {
    	return "hello, world";
    }

    @POST
    @Path("/register")
    @Template(name="/html/home")
    public String register() {
    	String user = null;

    	return user;
    }
}
