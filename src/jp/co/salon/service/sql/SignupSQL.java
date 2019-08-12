package jp.co.salon.service.sql;

public class SignupSQL {
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
}
