package jp.co.salon.controller;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.service.HomeService;

@Path("menu")
public class HomeController extends Controller {

	@GET
	@Path("/home")
	@Template(name="/html/home")
	public String toHome(@CookieParam("user") String cookie) {
		HomeService homeService = new HomeService();

		System.out.println("cookie value...");
		System.out.println(cookie);
		// cookieからIDを取得する
    	String groupList = homeService.getGroups(cookie);

		return "";
	}

	@GET
	@Path("/talk")
	@Template(name="/html/talk")
	public String toTalk() {
		return "";
	}

	@GET
	@Path("/add")
	@Template(name="/html/add")
	public String toAddFriends() {
		return "";
	}

	@GET
	@Path("/timeline")
	@Template(name="/html/timeline")
	public String toTimeline() {
		return "";
	}
}
