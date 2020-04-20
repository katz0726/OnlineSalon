package jp.co.salon.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	/**
	 * 概要：西暦下２桁を取得する。<br>
	 * 職員番号の西暦部分の設定に使用する。
	 * @return formatted 西暦下２桁
	 */
	public static String getLastTwoFigures() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy");

		String formatted = sdf.format(date);

		return formatted;
	}

	/**
	 * Summary：Check if Strings is null or empty
	 * @param str
	 * @return isEmpty
	 */
	public static boolean isEmpty(String str) {
		boolean emptyFlg = false;

		if (str == null || str.isEmpty()) {
			emptyFlg = true;
		}
		return emptyFlg;
	}

	/**
	 * Summary：Check if object is null
	 * @param object
	 * @return isEmpty
	 */
	public static boolean exists(Object object) {
		boolean emptyFlg = false;

		if (object == null) {
			emptyFlg = true;
		}
		return emptyFlg;
	}
}
