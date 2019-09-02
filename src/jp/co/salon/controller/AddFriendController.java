package jp.co.salon.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import jp.co.salon.service.AddFriendService;
@Provider
@Path("user")
public class AddFriendController extends Controller {
	private static AddFriendService addFriendService = AddFriendService.getInstance();

	/**
	 * Summary: sear
	 * @param searchId
	 * @return
	 */
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	public String searchFriend(String searchId) {

		String friend = addFriendService.getFriend(searchId);

		return friend;
	}
}