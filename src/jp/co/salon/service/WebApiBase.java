package jp.co.salon.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebApiBase  implements AutoCloseable {

	private Connection con = null;;

	/**
	 * 概要：コンストラクタ
	 * @param con コネクション
	 */
	public WebApiBase(Connection con) {
		this.con = con;
	}

	/**
	 * 概要：ステートメントに引数に設定したパラメータを設定する
	 * @param statement ステートメント
	 * @param params パラメータ
	 * @throws SQLException
	 */
	public void setParams(PreparedStatement statement, Object... params)
			throws SQLException {
		int paramNo = 1;

		// ループしてパラメータ設定する
		for (Object param : params) {
			statement.setObject(paramNo++, param);
		}
	}

	/**
	 * 概要：条件に合致するデータを全件取得する
	 * @param sql SQL文
	 * @param entity データクラス
	 * @param params パラメータ
	 * @return resultList 結果セット
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <E> List<E> findAll(String sql, Class<E> entity, Object... params)
			throws SQLException, InstantiationException,
			IllegalAccessException {

		ResultSet result = null;

		// ステートメントを作成
		PreparedStatement statement = con.prepareStatement(sql);

		// ステートメントにパラメータをセット
		setParams(statement, params);

		// SQLを実行
		result = statement.executeQuery();

		// リザルトセットをリストに格納
		List<E> resultList = toObjectList(result, entity);

		return resultList;
	}

	/**
	 *  概要：条件に合致するデータを１件取得する
	 * @param sql SQL文
	 * @param entity データクラス
	 * @param params パラメータ
	 * @return value 取得データエンティティ
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <E> E find(String sql, Class<E> entity, Object... params)
			throws SQLException, InstantiationException,
			IllegalAccessException {

		ResultSet result = null;

		// ステートメントを作成
		PreparedStatement statement = con.prepareStatement(sql);

		// ステートメントにパラメータをセット
		setParams(statement, params);

		// SQLの実行
		result = statement.executeQuery();

		E value = toObject(result, entity);

		return value;
	}

	/**
	 * 概要：ステートメント文の作成及びDB更新処理を実行する
	 * @param sql SQL文
	 * @param params SQLパラメータ
	 * @return updateCount 更新成功回数
	 * @throws SQLException
	 */
	public int save(String sql, Object... params) throws SQLException {

		// ステートメントを作成
		PreparedStatement statement = con.prepareStatement(sql);

		// ステートメントにパラメータをセット
		setParams(statement, params);

		// updateの実行
		int updateCount = 0;
		updateCount = statement.executeUpdate();

		return updateCount;
	}

	/**
	 * 概要：DBデータから指定されたクラスのオブジェクトへ変換する<br>
	 * clazzにjavaパッケージ配下のクラスを指定した場合は、1項目のみ設定する<br>
	 * @param rs リザルトセット
	 * @param clazz エンティティ
	 * @return bean
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	private static <E> E toObject(ResultSet result, Class<E> entity)
			throws InstantiationException, IllegalAccessException,
			SQLException {
		E bean = null;

		// リザルトセットのループを回す
		if (result.next()) {
			Field[] fields = entity.getFields();
			bean = entity.newInstance();

			//
			for (Field field : fields) {
				Object value = result.getObject(field.getName());
				field.set(bean, value);
			}
		}
		return bean;
	}

	/**
	 * 概要：DBデータから指定されたクラスのオブジェクトのリストへ変換する.
	 * @param rs DB取得結果
	 * @param entity エンティティ
	 * @return ビーンリスト
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private static <E> List<E> toObjectList(ResultSet result, Class<E> entity)
			throws SQLException, InstantiationException,
			IllegalAccessException {
		List<E> resultList = new ArrayList<>();

		// リザルトセットをループする
		while (result.next()) {
			Field[] fields = entity.getFields();
			E bean = entity.newInstance();

			// ループを回して
			for (Field field : fields) {
				Object value = result.getObject(field.getName());
				field.set(bean, value);
			}
			resultList.add(bean);
		}
		return resultList;
	}

	/**
	 * 概要：接続を閉じる<br>
	 * AutoCloseable インターフェースを使用しているため、DB処理終了後に<br>
	 * 必ず接続が閉じられる<br>
	 */
	@Override
	public void close() throws Exception {
		// コネクションを閉じる
		if (con != null) {
			con = null;
		}
	}
}
