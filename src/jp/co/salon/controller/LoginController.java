package jp.co.salon.controller;

import static jp.co.salon.service.WebApiBase.*;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.entity.LoginUser;
import jp.co.salon.service.LoginService;

@Path("/")
public class LoginController {
	private static LoginService loginService = LoginService.getInstance();

    @POST
    @Path("/home")
    @Template(name="/html/home")
    public List<Group> login(@FormParam("email") String email, @FormParam("password") String password) {

    	// ログイン認証を行う
    	LoginUser loginUser = loginService.auth(setParamOfLike(email, 2), setParamOfLike(password, 2));

    	// セッションに取得したログインユーザ情報を格納
    	if (loginUser != null) {
    	}

    	// グループを取得する
    	List<Group> groupList = loginService.getGroups(loginUser.getUser_id());

		return groupList;
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

		return "0";
    }
}
