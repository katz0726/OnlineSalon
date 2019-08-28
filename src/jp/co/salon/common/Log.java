package jp.co.salon.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	/**
	 * output trance log in Console & Log File
	 * @param msg
	 */
	public static void trace(String className, String msg) {
		if (!Utility.isEmpty(className)) {
			Logger logger = LogManager.getLogger(className);
			logger.trace(msg);
		}
	}

	/**
	 * output debug log in Console & Log File
	 * @param msg
	 */
	public static void error(String className, String msg) {
		if (!Utility.isEmpty(className)) {
			Logger logger = LogManager.getLogger(className);
			logger.error(msg);
		}
	}

	/**
	 * output warn log in Console & Log File
	 * @param msg
	 */
	public static void warn(String className, String msg) {
		if (!Utility.isEmpty(className)) {
			Logger logger = LogManager.getLogger(className);
			logger.warn(msg);
		}
	}

	/**
	 * output info log in Console & Log File
	 * @param msg
	 */
	public static void info(String className, String msg) {
		if (!Utility.isEmpty(className)) {
			Logger logger = LogManager.getLogger(className);
			logger.info(msg);
		}
	}

	/**
	 * output debug log in Console & Log File
	 * @param msg
	 */
	public static void debug(String className, String msg) {
		if (!Utility.isEmpty(className)) {
			Logger logger = LogManager.getLogger(className);
			logger.debug(msg);
		}
	}
}