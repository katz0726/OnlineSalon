package jp.co.salon.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.salon.entity.Group;
import jp.co.salon.entity.LoginUser;
import jp.co.salon.service.sql.LoginSQL;

public class LoginService extends WebApiBase {

	private static 	LoginService dbutil = new LoginService();

	/** コンストラクタ */
	private LoginService() {
		super();
		System.out.println("Create a instance of GroupService.....");
	}

	/** インスタンスを取得する */
	public static LoginService getInstance() {
		return dbutil;
	}

	/**
	 * 概要：ユーザが参加しているグループを取得する
	 * @return groupList グループリスト
	 */
	public List<Group> getGroups(String userId) {

		String sql = LoginSQL.getGroups();
		List<Group> groupList = new ArrayList<>();

		try {
			// グループを取得する
	    	groupList = dbutil.findAll(sql, Group.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
    	return groupList;
	}

	/**
	 * 概要：ユーザの認証処理を行う
	 * @param email
	 * @param password
	 * @return loginUser ログインユーザ情報
	 * @todo 認証処理を実装する
	 * @todo トランザクション制御する
	 */
	public LoginUser auth(String email, String password) {

		LoginUser loginUser = new LoginUser();

		try {
			// トランザクションを開始する
			//DBManager.begin();

			// 認証処理
			loginUser = dbutil.find(LoginSQL.authentication(), LoginUser.class, email, password);

	    	// ログイン状態をオンにする
			if (loginUser != null) {
				dbutil.save(LoginSQL.updateLoginStatusOn(), loginUser.getUser_id());
			}

			// トランザクション処理をコミットする
			//DBManager.commit();

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return loginUser;
	}

	/**
	 * 概要：ログアウト処理を行う
	 * @todo セッション開放処理を実装する
	 * @todo セッションからユーザIDを取得してログインステータスを変更できるようにする
	 */
	public void logout() {

		try {
			// ユーザが保持しているセッションを開放する

			// ログインステータスをオフにする
			dbutil.save(LoginSQL.updateLoginStatusOff(), "0019000001");
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}
