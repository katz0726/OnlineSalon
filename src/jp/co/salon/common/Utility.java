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
	 * 概要：数字を６桁の０埋めする。<br>
	 * シーケンステーブルから取得した数値をパディングして<br>
	 * 職員番号の連番部分の設定に使用する。
	 * @param sequance
	 * @return
	 */
	public static String paddingZeroForSeq(int sequance) {
		// ６桁に0埋め
		String paddingStr = String.format("%6s", sequance).replace(" ", "0");

		return paddingStr;

	}
}
