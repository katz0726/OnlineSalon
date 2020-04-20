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

import jp.co.salon.service.LoginService;

@Path("/")
public class LoginController extends Controller {

	/**
	 * Summary: authenticate login user
	 * @param loginUser
	 * @return groupList
	 */
    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response login(String loginUser, @CookieParam("user") NewCookie cookie) {
    	LoginService loginService = new LoginService();

    	// authenticate login user
    	String user = loginService.authenticate(loginUser);

    	// put login user's data into a cookie
    	if (cookie == null) {
    		cookie  = new NewCookie("user", user);
    	}
   		return Response.ok().entity(user).cookie(cookie).build();

    }


    /**
     * 概要：アプリケーションをログアウトする
     */
    @GET
    @Path("/logout")
    @Template(name="/index")
    public String logout() {
    	LoginService loginService = new LoginService();

		// ログイン状態をオフにする
		loginService.logout();

		return "";
    }
}
