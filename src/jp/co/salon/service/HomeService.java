package jp.co.salon.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.Log;
import jp.co.salon.entity.Group;
import jp.co.salon.service.sql.HomeSQL;

public class HomeService extends WebApiBase {
	private static HomeService dbutil = new HomeService();

	private HomeService() {
		System.out.println("Create a instance of HomeService.....");
	}

	public static HomeService getInstance() {
		return dbutil;
	}

	/**
	 * Summary：get the group that login user joins
	 * @param userId
	 * @return groupList the list of groups
	 */
	public List<Group> getGroups(String loginuser) {

		String sql = HomeSQL.getGroups();
		List<Group> groupList = new ArrayList<>();

		try {
				groupList = dbutil.findAll(sql, Group.class, loginuser);

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.GROUP_GET_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
    	return groupList;
	}
}
