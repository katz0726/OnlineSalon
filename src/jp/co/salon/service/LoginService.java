package jp.co.salon.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.Log;
import jp.co.salon.common.PasswordUtil;
import jp.co.salon.entity.User;
import jp.co.salon.service.sql.LoginSQL;

public class LoginService extends WebApiBase {

	private static 	LoginService dbutil = new LoginService();

	/** Constructor */
	private LoginService() {
		System.out.println("Create a instance of LoginService.....");
	}

	/** get Instance of LoginService */
	public static LoginService getInstance() {
		return dbutil;
	}

	/**
	 * Summary：authenticate login user
	 * @param email
	 * @param password
	 * @return loginUser login user data
	 */
	public String auth(String loginUser) {
		User user = null;
		String json = "";

		try {

			ObjectMapper mapper = new ObjectMapper();
			user = mapper.readValue(loginUser, User.class);

			// authentication
			String formHashedPassword = PasswordUtil.getSafetyPassword(user.getPassword(), user.getEmail());

			// get login user's data
			user = dbutil.find(LoginSQL.getLoginUser(), User.class, user.getEmail(), formHashedPassword);

	    	// turn login status on
			if (user == null) {
				new Exception();
			}

			// parse User class to JSON String
			json = mapper.writeValueAsString(user);

			// turn on login status
			dbutil.save(LoginSQL.updateLoginStatusOn(), user.getUser_id());

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USER_AUTHENTICATION_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
		return json;
	}

	/**
	 * 概要：ログアウト処理を行う
	 * @todo セッション開放処理を実装する
	 * @todo セッションからユーザIDを取得してログインステータスを変更できるようにする
	 */
	public void logout() {

		try {
			// ログインステータスをオフにする
			dbutil.save(LoginSQL.updateLoginStatusOff(), "0019000001");

			// ユーザが保持しているセッションを開放する

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USER_LOGOUT_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
	}
}
