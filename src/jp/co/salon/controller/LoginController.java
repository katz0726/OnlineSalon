package jp.co.salon.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.service.WebApiBase;
import jp.co.salon.service.sql.LoginSQL;

@Path("/")
public class LoginController {

    @POST
    @Path("/home")
    @Template(name="/html/home")
    public List<Group> confirm() {
		WebApiBase dbutil = new WebApiBase();
		String sql = LoginSQL.getGroups();

    	List<Group> groupList = dbutil.findAll(sql, Group.class, 1);
    	System.out.println(groupList);

    	// ログイン状態をオンにする
    	dbutil.save(LoginSQL.updateLoginStatusOn(), "0019000001");

		return groupList;
    }


    /**
     * 概要：アプリケーションをログアウトする
     */
    @GET
    @Path("/logout")
    @Template(name="/index")
    public String logout() {
		WebApiBase dbutil = new WebApiBase();

		// ログイン状態をオフにする
		dbutil.save(LoginSQL.updateLoginStatusOff(), "0019000001");
		return "0";
    }
}
