package jp.co.salon.service;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Path;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.salon.entity.User;
import jp.co.salon.service.sql.AddFriendSQL;

@Path("user")
public class AddFriendService extends WebApiBase {

	private static 	AddFriendService dbutil = new AddFriendService();

	/** Constructor */
	private AddFriendService() {
		super();
		System.out.println("Create a instance of AddFriendService.....");
	}

	/** get an instance */
	public static AddFriendService getInstance() {
		return dbutil;
	}

	/**
	 * Summary：Get a friend matched search ID
	 * @return friend friend data class
	 */
	public String getFriend(String seachId) {

		Map<String, Object> searchCondition = new LinkedHashMap<>();
		User friend = new User();
		String json = "";

		try {
			ObjectMapper mapper = new ObjectMapper();

			// convert a search condition JSON to LinkedHashMap
			searchCondition = mapper.readValue(seachId, new TypeReference<LinkedHashMap<String, Object>>(){});

			// a friend matched search ID
			String sql = AddFriendSQL.getFriend();
			friend = dbutil.find(sql, User.class, searchCondition.get("condition1"));

			// convert search result to JSON
			json = mapper.writeValueAsString(friend);

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
    	return json;
	}
}
