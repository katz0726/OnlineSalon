package jp.co.salon.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.service.WebApiBase;
import jp.co.salon.service.sql.CreateGroupSQL;

@Path("api")
public class LoginController {
    @GET
    @Path("/hello-mvc")
    @Template(name="/html/hello-mvc")
    public String helloWorld() {

			WebApiBase dbutil = new WebApiBase();
			String sql = CreateGroupSQL.getGroups();

	    	List<Group> groupList = dbutil.findAll(sql, Group.class, 1);

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
