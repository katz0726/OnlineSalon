package jp.co.salon.common;

public class AppConst {
	/**DB Settings */
	public static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Salon";
	public static final String DB_HOST = "127.0.0.1";
	public static final String DB_PORT = "5432";
	public static final String DBNAME = "Salon";
	public static final String DB_USER = "shoya";
	public static final String DB_PASSWORD = "bier0726";

	/**
	 * Summary: Error Messages
	 * @author swgt1s
	 */
	public static class ErrorMessage {
		public static final String SEQUENCE_GET_FAILED_ERROR = "シーケンスの取得に失敗しました";
		public static final String USER_REGISTRATION_FAILED_ERROR = "ユーザの登録処理に失敗しました";
		public static final String USERNAME_CHECK_FAILED_ERROR = "ユーザ名重複チェック処理に失敗しました";
		public static final String USER_DUPLICATE_ERROR = "ユーザ名が重複しています";
		public static final String USER_AUTHENTICATION_ERROR = "ユーザ認証処理に失敗しました";
		public static final String GROUP_GET_FAILED_ERROR = "グループの取得に失敗しました";
		public static final String USER_LOGOUT_ERROR = "ログアウト処理に失敗しました";
	}

	/**
	 * Summary: Messages related to DB access
	 * @author swgt1s
	 */
	public static class DBAccessMessage {
		public static final String DB_CONNECTION_ERROR = "DB接続に失敗しました";
		public static final String DB_GET_FAILED_ERROR = "DB取得処理に失敗しました";
		public static final String DB_REGISTER_FAILED_ERROR = "DB登録更新処理に失敗しました";
	}
}