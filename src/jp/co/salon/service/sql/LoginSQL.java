package jp.co.salon.service.sql;

public class LoginSQL {

	/**
	 * 概要：ユーザIDに紐づくグループ情報を<br>
	 * すべて取得するSQLを作成する
	 * @return sql SQL文
	 */
	public static String getGroups() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("	group_id, ");
		sql.append("	group_name, ");
		sql.append("	modified ");
		sql.append("FROM ");
		sql.append("	public.trn_chat_group AS groups ");
		sql.append("WHERE ");
		sql.append("	groups.user_id = ?;");

		return sql.toString();
	}

	/**
	 * 概要：ユーザIDに紐づくグループ情報を<br>
	 * １件取得するSQLを作成する
	 * @return sql SQL文
	 */
	public static String getGroup() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("	group_id, ");
		sql.append("	group_name, ");
		sql.append("	modified ");
		sql.append("FROM ");
		sql.append("	public.trn_chat_group AS groups ");
		sql.append("WHERE ");
		sql.append("	groups.group_id = ?;");

		return sql.toString();
	}
	/**
	 * 概要：ユーザIDに紐づくグループ名を<br>
	 * 更新するSQLを作成する
	 * @return sql SQL文
	 */
	public static String insertGroup() {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO ");
		sql.append("	public.trn_chat_group ( ");
		sql.append("	 	group_id, ");
		sql.append("	 	user_id, ");
		sql.append("	 	group_name) ");
		sql.append("VALUES ( ?, ?, ?);");

		return sql.toString();
	}

	/**
	 * 概要：ユーザIDに紐づくグループ名を<br>
	 * 更新するSQLを作成する
	 * @return sql SQL文
	 */
	public static String updateGroupName() {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE ");
		sql.append("	public.trn_chat_group AS groups ");
		sql.append("SET ");
		sql.append("	groups.group_name = ? ");
		sql.append("WHERE ");
		sql.append("	groups.group_id = ?;");

		return sql.toString();
	}

	public static String updateLoginStatusOn() {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE ");
		sql.append("	public.trn_user ");
		sql.append("SET ");
		sql.append("	login_flg = 1 ");
		sql.append("WHERE ");
		sql.append("	user_id = ?;");

		return sql.toString();
	}

	public static String updateLoginStatusOff() {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE ");
		sql.append("	public.trn_user ");
		sql.append("SET ");
		sql.append("	login_flg = 0 ");
		sql.append("WHERE ");
		sql.append("	user_id = ?;");

		return sql.toString();
	}
}