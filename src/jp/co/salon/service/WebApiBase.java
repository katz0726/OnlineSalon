package jp.co.salon.service;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.salon.common.AppConst.DBAccessMessage;
import jp.co.salon.common.DBManager;
import jp.co.salon.common.Log;

public class WebApiBase {

    /**
     * Summary: get all data matched to conditions
     *
     * @param sql
     *            statement
     * @param entity
     *            data class
     * @param params
     *            parameters
     * @return resultList
     */
    public <E> List<E> findAll(String sql, Class<E> entity, Object... params) {

	ResultSet result = null;
	List<E> resultList = new ArrayList<>();

	try (Connection con = DBManager.getConnection();) {
	    try (PreparedStatement statement = con.prepareStatement(sql);) {

		// set Parameters to statement
		setParams(statement, params);

		// execute query
		result = statement.executeQuery();

		// set resultseet into a list
		resultList = toObjectList(result, entity);

	    } catch (Exception e) {
		throw e;
	    }
	} catch (Exception e) {
	    Log.error(getClass().getName(), DBAccessMessage.DB_GET_FAILED_ERROR);
	    e.printStackTrace();
	    e.getMessage();
	}
	return resultList;
    }

    /**
     * Summary: get data matched to conditions
     *
     * @param sql
     *            SQL statement
     * @param entity
     *            data class
     * @param params
     *            parameters
     * @return value entity
     */
    protected <E> E find(String sql, Class<E> entity, Object... params) {

	ResultSet result = null;
	E value = null;

	try (Connection con = DBManager.getConnection();) {
	    try (PreparedStatement statement = con.prepareStatement(sql);) {

		// set Parameters to statement
		setParams(statement, params);

		// execute query
		result = statement.executeQuery();

		value = toObject(result, entity);
	    } catch (Exception e) {
		throw e;
	    }
	} catch (Exception e) {
	    Log.error(getClass().getName(), DBAccessMessage.DB_GET_FAILED_ERROR);
	    e.printStackTrace();
	    e.getMessage();
	}
	return value;
    }

    /**
     * Summary: register or update database
     *
     * @param sql
     *            statement
     * @param params
     *            parameters
     * @return updateCount update count
     */
    protected int save(String sql, Object... params) {

	int updateCount = 0;

	try (Connection con = DBManager.getConnection();) {
	    // トランザクションの開始
	    con.setAutoCommit(false);
	    try (PreparedStatement statement = con.prepareStatement(sql);) {
		// ステートメントにパラメータをセット
		setParams(statement, params);

		// updateの実行
		updateCount = statement.executeUpdate();

		// コミット
		con.commit();
	    } catch (Exception e) {
		// ロールバック
		con.rollback();
		throw e;
	    }
	} catch (Exception e) {
	    Log.error(getClass().getName(), DBAccessMessage.DB_REGISTER_FAILED_ERROR);
	    e.printStackTrace();
	    e.getMessage();
	}
	return updateCount;
    }

    /**
     * 概要：集計SQLの結果を返す
     *
     * @param sql
     *            statement
     * @param params
     *            parameters
     * @return counter number of count
     */
    protected int count(String sql, Object... params) {
	ResultSet result = null;
	int counter = 0;

	try (Connection con = DBManager.getConnection();) {
	    try (PreparedStatement statement = con.prepareStatement(sql);) {
		// ステートメントにパラメータをセット
		setParams(statement, params);

		// SQLの実行
		result = statement.executeQuery();
		counter = result.getInt("count");

	    } catch (Exception e) {
		throw e;
	    }
	} catch (Exception e) {
	    Log.error(getClass().getName(), DBAccessMessage.DB_GET_FAILED_ERROR);
	    e.printStackTrace();
	    e.getMessage();
	}
	return counter;
    }

    /**
     * 概要：ステートメントに引数に設定したパラメータを設定する
     *
     * @param statement
     *            prepared statement
     * @param params
     *            parameters
     * @throws SQLException
     */
    private static void setParams(PreparedStatement statement, Object... params) throws SQLException {
	int paramNo = 1;

	// ループしてパラメータ設定する
	for (Object param : params) {
	    statement.setObject(paramNo++, param);
	}
    }

    /**
     * 概要：LIKE文にパラメータとして設定する文字列を生成する
     *
     * @param paramString
     *            LIKE文を生成対象文字列
     * @param searchKind
     *            LIKE検索種別<br>
     *            [1]: 前方一致<br>
     *            [2]: 部分一致<br>
     *            [3]: 後方一致
     * @return likeStatement LIKE statement
     */
    public static String setParamOfLike(String paramString, int searchKind) {
	StringBuilder likeStatement = new StringBuilder();

	// searchKindが「1」の場合、前方一致
	if (searchKind == 1) {
	    likeStatement.append("%");
	    likeStatement.append(paramString);

	} else if (searchKind == 2) {
	    likeStatement.append("%");
	    likeStatement.append(paramString);
	    likeStatement.append("%");

	} else if (searchKind == 3) {
	    likeStatement.append(paramString);
	    likeStatement.append("%");
	} else {
	    // それ以外の場合は処理しない
	}

	return likeStatement.toString();
    }

    /**
     * Summary：Convert the data that get from DB to data class
     *
     * @param result
     *            resultset
     * @param entity
     *            data class
     * @return bean
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws SecurityException
     */
    private static <E> E toObject(ResultSet result, Class<E> entity)
	    throws InstantiationException, IllegalAccessException, SQLException {
	E bean = null;

	// リザルトセットのループを回す
	if (result.next()) {
	    Field[] fields = entity.getDeclaredFields();
	    bean = entity.newInstance();

	    for (Field field : fields) {
		field.setAccessible(true);

		try {
		    Object value = result.getObject(field.getName());
		    field.set(bean, value);

		} catch (SQLException e) {
		    continue;
		}
	    }
	}
	return bean;
    }

    /**
     * 概要：DBデータから指定されたクラスのオブジェクトのリストへ変換する.
     *
     * @param result
     *            resultset
     * @param entity
     *            dataclass
     * @return ビーンリスト
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static <E> List<E> toObjectList(ResultSet result, Class<E> entity)
	    throws SQLException, InstantiationException, IllegalAccessException {
	List<E> resultList = new ArrayList<>();

	// リザルトセットをループする
	while (result.next()) {
	    Field[] fields = entity.getDeclaredFields();
	    E bean = entity.newInstance();

	    for (Field field : fields) {
		field.setAccessible(true);

		try {
		    Object value = result.getObject(field.getName());
		    field.set(bean, value);

		} catch (SQLException e) {
		    continue;
		}
	    }
	    resultList.add(bean);
	}
	return resultList;
    }
}
