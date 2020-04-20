package jp.co.salon.service.sql;

public class SignupSQL {

	/**
	 * Summary: Create SQL to register the information of  signup user
	 * @return sql SQL
	 */
	public static String insertUser() {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT ");
		sql.append("	INTO public.trn_users ( ");
		sql.append("	 	user_id ");
		sql.append("	 	,user_name ");
		sql.append("	 	,gender ");
		sql.append("	 	,email ");
		sql.append("	 	,password ");
		sql.append("	 	,search_id ");
		sql.append("	) VALUES ( ?, ?, ?, ?, ?, ?);");

		return sql.toString();
	}

	/**
	 * Summary：Get signup user
	 * @return sql
	 */
	public static String getSignupUser() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("	user_id, ");
		sql.append("	user_name ");
		sql.append("FROM ");
		sql.append("	public.trn_users ");
		sql.append("WHERE ");
		sql.append("	user_id = ? ");

		return sql.toString();
	}

	/**
	 * Summary: Get User ID from sequence table
	 * @return sql
	 */
	public static String getUserIdSequence() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	nextval('trn_users_user_id_seq');");

		return sql.toString();
	}

	/**
	 * Summar: Check if user name is the same as registered user names
	 * @return sql
	 */
	public static String checkUsername() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("	count(*) ");
		sql.append("FROM ");
		sql.append("	public.trn_users ");
		sql.append("WHERE ");
		sql.append("	user_name = ?;");

		return sql.toString();
	}
}
