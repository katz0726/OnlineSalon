package jp.co.salon.service;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.Log;
import jp.co.salon.entity.Group;
import jp.co.salon.entity.User;
import jp.co.salon.service.sql.HomeSQL;

public class HomeService extends WebApiBase {
	/**
	 * Summary：get the group that login user joins
	 * @param userId
	 * @return groupList the list of groups
	 */
	public String getGroups(String loginuser) {

		String json = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(loginuser, User.class);

			// get user's groups
			String sql = HomeSQL.getGroups();
			HomeService homeservice = new HomeService();
			List<Group> groupList = homeservice.findAll(sql, Group.class, user.getUser_id());

			// parse User class to JSON String
			json = mapper.writeValueAsString(groupList);

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.GROUP_GET_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
    	return json;
	}
}
