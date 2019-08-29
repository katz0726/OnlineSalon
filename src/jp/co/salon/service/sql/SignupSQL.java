package jp.co.salon.service.sql;

public class SignupSQL {

	/**
	 * 概要：ユーザIDに紐づくグループ名を<br>
	 * 更新するSQLを作成する
	 * @return sql SQL文
	 */
	public static String getUserIdSequence() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	nextval('user_id_seq');");

		return sql.toString();
	}

	/**
	 * Summary: create SQL to register the information of  signup user
	 * @return sql SQL
	 */
	public static String insertUser() {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT ");
		sql.append("	INTO public.trn_user ( ");
		sql.append("	 	user_id, ");
		sql.append("	 	user_name, ");
		sql.append("	 	email, ");
		sql.append("	 	password) ");
		sql.append("	VALUES ( ?, ?, ?, ?);");

		return sql.toString();
	}

	/**
	 * Summary：Check if user name is the same as registered user names
	 * @return sql
	 */
	public static String checkUsername() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	count(*) ");
		sql.append("FROM ");
		sql.append("	public.trn_user ");
		sql.append("WHERE ");
		sql.append("	user_name = ?;");

		return sql.toString();
	}
}
