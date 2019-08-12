package jp.co.salon.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.service.WebApiBase;
import jp.co.salon.service.sql.LoginSQL;

@Path("menu")
public class HomeController {

	@GET
	@Path("/home")
	@Template(name="/html/home")
	public List<Group> toHome() {
		WebApiBase dbutil = new WebApiBase();
		String sql = LoginSQL.getGroups();

    	List<Group> groupList = dbutil.findAll(sql, Group.class, "0019000001");
    	System.out.println(groupList);
		return groupList;
	}

	@GET
	@Path("/talk")
	@Template(name="/html/talk")
	public String toTalk() {
		System.out.println(2);
		return "2";
	}

	@GET
	@Path("/add")
	@Template(name="/html/add")
	public String toAddFriends() {
		System.out.println(3);
		return "3";
	}

	@GET
	@Path("/timeline")
	@Template(name="/html/timeline")
	public String toTimeline() {
		System.out.println(4);
		return "4";
	}
}
