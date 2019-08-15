package jp.co.salon.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.service.SignupService;

@Path("/")
public class SignupController {
	private static SignupService signupService = SignupService.getInstance();

    @GET
    @Path("/signup")
    @Template(name="/html/signup")
    public String index() {
    	return "hello, world";
    }

    @POST
    @Path("/register")
    @Template(name="/html/home")
    public String register(@FormParam("username") String username,
        	@FormParam("email") String email, @FormParam("password") String password) {
    	String user = null;

    	System.out.println(signupService);

    	return user;
    }
}
