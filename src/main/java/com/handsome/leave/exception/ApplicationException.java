package com.handsome.leave.exception;

/**
 * ApplicationException
 *
 * @author handsome
 * @date 2020年 04月10日 23:14:30
 */
public class ApplicationException extends RuntimeException {

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
