package com.handsome.leave.dto;

/**
 * LeaveResult
 *
 * @author handsome
 * @date 2020年 03月16日 23:49:04
 */
public class LeaveResult<T> {

	private boolean success;

	private T data;

	private String error;

	public LeaveResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public LeaveResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
