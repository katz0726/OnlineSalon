package jp.co.salon.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.service.SignupService;

@Path("/")
public class SignupController extends Controller {

    @GET
    @Path("signup")
    @Template(name="/html/signup")
    public String index() {
    	return "";
    }

    @POST
    @Path("signup")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response signup(String formUser, @CookieParam("user") NewCookie cookie) {
    	SignupService signupService = new SignupService();

    	// register signup user
    	int userId =  signupService.register(formUser);

    	String signupUser = signupService.getUser(userId);

    	// put login user's data into a cookie
    	if (cookie == null) {
    		cookie = new NewCookie("user", signupUser);
    	}
		return Response.ok().entity(signupUser).cookie(cookie).build();
    }
}
