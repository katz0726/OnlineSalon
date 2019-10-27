package jp.co.salon.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements AutoCloseable {
	private static Connection con = null;

	public static Connection getConnection()
			throws SQLException, ClassNotFoundException {
		/** クラスのロード */
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(AppConst.DB_URL, AppConst.DB_USER, AppConst.DB_PASSWORD);

		return con;
	}

	/**
	 * 概要：トランザクション開始処理<br>
	 * オートコミットをオフにする
	 * @throws SQLException
	 */
	public static void begin() throws SQLException {
		con.setAutoCommit(false);
	}

	/**
	 * 概要：トランザクションコミット処理<br>
	 * 実行されたDB処理をコミットする
	 * @throws SQLException
	 */
	public static void commit() throws SQLException {
		con.commit();
	}
	public static String getHost() {
		return AppConst.DB_HOST;
	}

	public static String getPort() {
		return AppConst.DB_PORT;
	}

	public static String getDB() {
		return AppConst.DBNAME;
	}

	/**
	 * 概要：コネクションを閉じる<br>
	 * AutoCloseable インターフェースを実装しているため<br>
	 * 呼び出し後自動的にコネクションを閉じる
	 */
	@Override
	public void close() throws Exception {
		// コネクションを閉じる
		if (con != null) {
			con = null;
		}
	}
}