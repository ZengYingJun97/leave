package com.handsome.leave.model;

/**
 * Instructor
 *
 * @author handsome
 * @date 2020年 03月08日 16:39:33
 */
public class Instructor {
	
	private long instructorId;

	private String instructorName;

	private String instructorAccount;

	private String instructorPassword;

	public long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getInstructorAccount() {
		return instructorAccount;
	}

	public void setInstructorAccount(String instructorAccount) {
		this.instructorAccount = instructorAccount;
	}

	public String getInstructorPassword() {
		return instructorPassword;
	}

	public void setInstructorPassword(String instructorPassword) {
		this.instructorPassword = instructorPassword;
	}
}
