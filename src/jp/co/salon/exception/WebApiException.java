package jp.co.salon.exception;

/**
 *
 * @author swgt1
 *
 */
public class WebApiException extends RuntimeException {

	/**
	 * Summary:
	 * @param message
	 * @param cause
	 */
	public WebApiException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Summary:
	 * @param message
	 */
	public WebApiException(String message) {
		super(message);
	}

	/**
	 * Summary
	 * @param cause
	 */
	public WebApiException(Throwable cause) {
		super(cause);
	}
}
