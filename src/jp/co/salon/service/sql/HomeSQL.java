package jp.co.salon.service.sql;

public class HomeSQL {
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
}
