package jp.co.salon.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.exception.WebApiException;
import jp.co.salon.service.LoginService;

@Path("/")
public class LoginController extends Controller {
	private static LoginService loginService = LoginService.getInstance();

	/**
	 * Summary: authenticate login user
	 * @param loginUser
	 * @return groupList
	 */
    @POST
    @Path("/auth")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response login(String loginUser) {

    	// authenticate login user
    	String user = loginService.auth(loginUser);

    	// put login user's data into a cookie
    	NewCookie cookie = null;
    	if (user != null) {
    		cookie = new NewCookie("user", user);
    	} else {
    		throw new WebApiException(ErrorMessage.USER_AUTHENTICATION_ERROR);
    	}

		return Response.ok().cookie(cookie).build();
    }


    /**
     * 概要：アプリケーションをログアウトする
     */
    @GET
    @Path("/logout")
    @Template(name="/index")
    public String logout() {

		// ログイン状態をオフにする
		loginService.logout();

		return "";
    }
}
