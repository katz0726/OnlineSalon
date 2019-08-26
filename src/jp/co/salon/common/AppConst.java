package jp.co.salon.common;

public class AppConst {
	/** DB設定 */
	public static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Salon";
	public static final String DB_HOST = "127.0.0.1";
	public static final String DB_PORT = "5432";
	public static final String DBNAME = "Salon";
	public static final String DB_USER = "shoya";
	public static final String DB_PASSWORD = "bier0726";

	public static class ErrorMessage {
		public static final String SEQUENCE_GET_FAILED_ERROR = "シーケンスの取得に失敗しました";
		public static final String USER_REGISTRATION_FAILED_ERROR = "ユーザの登録処理に失敗しました";
	}
}