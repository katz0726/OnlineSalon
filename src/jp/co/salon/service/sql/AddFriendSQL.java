package jp.co.salon.service.sql;

public class AddFriendSQL {

	/**
	 * Summary:
	 * @return sql
	 */
	public static String getFriend() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("	user_id, ");
		sql.append("	user_name, ");
		sql.append("	email, ");
		sql.append("	password, ");
		sql.append("	search_id ");
		sql.append("FROM ");
		sql.append("	public.trn_user ");
		sql.append("WHERE ");
		sql.append("	search_id = ?;");

		return sql.toString();
	}
}
