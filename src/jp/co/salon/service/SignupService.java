	package jp.co.salon.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.DBManager;
import jp.co.salon.common.Utility;
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
	public void registerUser(String username, String email, String password) {

		try {
			String userid = createUserId();

			// register user
			dbutil.save(SignupSQL.insertUser(), userid, username, email, password);

		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ErrorMessage.USER_REGISTRATION_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
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
			System.out.println(e.getClass().getName() + ErrorMessage.SEQUENCE_GET_FAILED_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return userIdStr;
	}
}
