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
}
