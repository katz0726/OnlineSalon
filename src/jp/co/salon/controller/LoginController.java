package jp.co.salon.controller;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.service.WebApiBase;
import jp.co.salon.service.sql.CreateGroupSQL;

@Path("/")
public class LoginController {

    @POST
    @Path("/home")
    @Template(name="/html/home")
    public List<Group> confirm() {
		WebApiBase dbutil = new WebApiBase();
		String sql = CreateGroupSQL.getGroups();

    	List<Group> groupList = dbutil.findAll(sql, Group.class, 1);
    	System.out.println(groupList);
		return groupList;
    }

}
