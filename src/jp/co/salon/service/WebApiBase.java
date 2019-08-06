package jp.co.salon.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.salon.common.DBManager;

public class WebApiBase {

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
	public <E> List<E> findAll(String sql, Class<E> entity, Object... params) {

		ResultSet result = null;
		List<E> resultList = new ArrayList<>();

		try (Connection con = DBManager.getConnection();) {
			try (PreparedStatement statement = con.prepareStatement(sql);) {

				// ステートメントにパラメータをセット
				setParams(statement, params);

				// SQLを実行
				result = statement.executeQuery();

				// リザルトセットをリストに格納
				resultList = toObjectList(result, entity);


			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
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
	public <E> E find(String sql, Class<E> entity, Object... params) {

		ResultSet result = null;
		E value = null;

		try (Connection con = DBManager.getConnection();) {
			try (PreparedStatement statement = con.prepareStatement(sql);) {
				// ステートメントにパラメータをセット
				setParams(statement, params);

				// SQLの実行
				result = statement.executeQuery();

				value = toObject(result, entity);
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return value;
	}

	/**
	 * 概要：ステートメント文の作成及びDB更新処理を実行する
	 * @param sql SQL文
	 * @param params SQLパラメータ
	 * @return updateCount 更新成功回数
	 * @throws SQLException
	 */
	public int save(String sql, Object... params) {

		int updateCount = 0;

		try (Connection con = DBManager.getConnection();) {
			try (PreparedStatement statement = con.prepareStatement(sql);) {
				// ステートメントにパラメータをセット
				setParams(statement, params);

				// updateの実行
				updateCount = statement.executeUpdate();
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
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
			Field[] fields = entity.getDeclaredFields();
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
			Field[] fields = entity.getDeclaredFields();
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
}
