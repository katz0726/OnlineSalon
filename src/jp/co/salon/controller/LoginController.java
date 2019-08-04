package jp.co.salon.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.common.DBManager;
import jp.co.salon.entity.Group;
import jp.co.salon.service.WebApiBase;
import jp.co.salon.service.sql.createGroupSQL;

@Path("api")
public class LoginController {
    @GET
    @Path("/hello-mvc")
    @Template(name="/html/hello-mvc")
    public String helloWorld() {

 		try {
			WebApiBase dbutil = new WebApiBase(DBManager.getConnection());

	    	List<Group> groupList = dbutil.findAll(createGroupSQL.getGroups(), Group.class, 1);

	    	System.out.println(groupList);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



        return "Hello, world";
    }

    @POST
    @Path("/confirm")
    @Template(name="/html/confirm")
    public Map<String, Object> confirm() {
		Map<String, Object> model = new HashMap<String, Object>();
		Date now = new Date();

		model.put("id", "0000001");
		model.put("name", "渡辺　翔也");
		model.put("email", "sample@gmail.com");
		model.put("timestamp", now);
		return model;
    }
}
