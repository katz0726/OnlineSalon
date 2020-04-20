package jp.co.salon.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.salon.common.AppConst.ErrorMessage;
import jp.co.salon.common.Log;
import jp.co.salon.common.PasswordManager;
import jp.co.salon.entity.User;
import jp.co.salon.service.sql.LoginSQL;

public class LoginService extends WebApiBase {
	/**
	 * Summary：authenticate login user
	 * @param loginUser
	 * @return json login user data
	 */
	public String authenticate(String userJson) {
		String json = "";

		try {
			ObjectMapper mapper = new ObjectMapper();
			User loginForm = mapper.readValue(userJson, User.class);

			// authentication
			String hashedPassword = PasswordManager.getSafetyPassword(loginForm.getPassword(), loginForm.getEmail());

			// get login user's data
			User loginUser = super.find(LoginSQL.getLoginUser(), User.class, loginForm.getEmail(), hashedPassword);

			// parse User class to JSON String
			ObjectMapper mapper2 = new ObjectMapper();
			json = mapper2.writeValueAsString(loginUser);

			// turn on login status
			super.save(LoginSQL.updateLoginStatusOn(), loginUser.getUser_id());

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
			super.save(LoginSQL.updateLoginStatusOff(), "0019000001");

		} catch (Exception e) {
			Log.error(getClass().getName(), ErrorMessage.USER_LOGOUT_ERROR);
			e.printStackTrace();
			e.getMessage();
		}
	}
}
