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
}
