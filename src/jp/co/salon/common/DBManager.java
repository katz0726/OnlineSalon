package jp.co.salon.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements AutoCloseable {
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/Salon";
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "5432";
	private static final String DBNAME = "Salon";
	private static final String DB_USER = "shoya";
	private static final String DB_PASSWORD = "bier0726";

	private static Connection con = null;

	public static Connection getConnection()
			throws SQLException, ClassNotFoundException {
		/** クラスのロード */
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
		return DB_HOST;
	}

	public static String getPort() {
		return DB_PORT;
	}

	public static String getDB() {
		return DBNAME;
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