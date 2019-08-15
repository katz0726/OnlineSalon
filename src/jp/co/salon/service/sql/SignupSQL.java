package jp.co.salon.service.sql;

public class SignupSQL {
	/**
	 * 概要：ユーザIDに紐づくグループ名を<br>
	 * 更新するSQLを作成する
	 * @return sql SQL文
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

		System.out.println(sql.toString());
		return sql.toString();
	}
}
