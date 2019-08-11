package jp.co.salon.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

@Path("menu")
public class HomeController {

	@GET
	@Path("/home")
	@Template(name="/html/home")
	public String toHome() {
		System.out.println(1);
		return "1";
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
