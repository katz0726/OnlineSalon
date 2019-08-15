package jp.co.salon.service;

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
	public boolean registerUser(String username, String email, String password) {

		boolean execFlg = false;
		try {
			// register user
			dbutil.save(SignupSQL.insertUser(), username, email, password);
			execFlg = true;

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return execFlg;
	}
}
