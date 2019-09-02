package jp.co.salon.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Template;

import jp.co.salon.entity.Group;
import jp.co.salon.service.HomeService;

@Path("menu")
public class HomeController extends Controller {
	private static HomeService homeService = HomeService.getInstance();

	@GET
	@Path("/home")
	@Template(name="/html/home")
	public List<Group> toHome() {
    	List<Group> groupList = homeService.getGroups("0019000001");

		return groupList;
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
