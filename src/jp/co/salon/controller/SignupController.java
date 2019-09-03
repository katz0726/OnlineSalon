package jp.co.salon.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.exception.WebApiException;
import jp.co.salon.service.SignupService;

@Path("/")
public class SignupController extends Controller {
	private static SignupService signupService = SignupService.getInstance();

    @GET
    @Path("signup")
    @Template(name="/html/signup")
    public String index() {
    	return "";
    }

    @POST
    @Path("register")
    @Template(name="/html/home")
    public String register(@FormParam("username") String username,
        	@FormParam("email") String email, @FormParam("password") String password) {

    	// register signup user
    	String userId =  signupService.registerUser(username, email, password);


    	String signupUser = signupService.getUser(userId);
    	// put login user's data into a cookie
    	NewCookie cookie = null;
    	if (signupUser != null) {
    		cookie = new NewCookie("user", signupUser);
    	} else {
    		throw new WebApiException(ErrorMessage.USER_AUTHENTICATION_ERROR);
    	}

    	return "";
    }
}
