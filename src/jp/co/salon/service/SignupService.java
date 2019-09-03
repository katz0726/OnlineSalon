	package jp.co.salon.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.DBManager;
import jp.co.salon.common.Log;
import jp.co.salon.common.PasswordUtil;
import jp.co.salon.common.Utility;
import jp.co.salon.entity.User;
import jp.co.salon.service.sql.SignupSQL;

public class SignupService extends WebApiBase {

	private static 	SignupService dbutil = new SignupService();

	/** Constructor */
	private SignupService() {
		super();
		System.out.println("Create a instance of SignupService.....");
	}

	/** get a instance of SignupService class */
	public static SignupService getInstance() {
		return dbutil;
	}


	/**
	 * Summary: Register a signup user
	 * @param username a name of user
	 * @param email User's email
	 * @param password User's password
	 */
	public String registerUser(String username, String email, String password) {

		String userid = null;
		try {
			// check if user name is duplicated
			if (checkDuplicateUserName(username)) {
				Log.error(getClass().getName(), ErrorMessage.USER_DUPLICATE_ERROR);
				throw new Exception();
			}

			// register user
			userid = createUserId();
			String hashedPassword = PasswordUtil.getSafetyPassword(password, email);
			dbutil.save(SignupSQL.insertUser(), userid, username, email, hashedPassword);

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USER_REGISTRATION_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return userid;
	}

	/**
	 * Summary: Get signup user
	 * @param userid
	 * @return json
	 */
	public String getUser(String userid) {

		String json = null;
		try {
			// get signup user
			User signupUser = null;
			if (userid != null) {
				signupUser = dbutil.find(SignupSQL.getSignupUser(), User.class, userid);
			}

			// convert User class to json
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(signupUser);

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USER_GET_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return json;
	}

	/**
	 * Summary: get a new user id from DB
	 * @return userId
	 */
	private String createUserId() {
		StringBuilder userId = new StringBuilder();

		userId.append("01");
		userId.append(Utility.getLastTwoFigures());

		// get sequence
		String userIdSeq = getSequence(SignupSQL.getUserIdSequence());
		userId.append(String.format("%6s", userIdSeq).replace(" ", "0"));

		return userId.toString();
	}

	/**
	 * Summary: Get the sequence of user id from DB
	 * @param sql
	 * @return userId
	 */
	private String getSequence(String sql) {
		String userIdStr = "";

		try(Connection con = DBManager.getConnection();) {
			try (PreparedStatement statement = con.prepareStatement(sql);) {

				ResultSet rs = statement.executeQuery();

				int userId = 0;
				if (rs.next()) {
					userId = rs.getInt(1);
				}
				userIdStr = (userId != 0) ? Integer.toString(userId) : "";
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.SEQUENCE_GET_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return userIdStr;
	}

	/**
	 * Summary: Check if username is duplicated
	 * @param username
	 * @return duplicateFlg
	 */
	private boolean checkDuplicateUserName(String username) {
		boolean duplicateFlg = false;
		try(Connection con = DBManager.getConnection();) {
			try (PreparedStatement statement = con.prepareStatement(SignupSQL.checkUsername());) {

				statement.setString(1, username);

				ResultSet rs = statement.executeQuery();

				int count = 0;
				if (rs.next()) {
					count = rs.getInt(1);
				}
				// chenge the status of duplicateFlg
				duplicateFlg = (0 < count) ? true : false;
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USERNAME_CHECK_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return duplicateFlg;
	}
}
