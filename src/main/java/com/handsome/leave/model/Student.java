package com.handsome.leave.model;

/**
 * Student
 *
 * @author handsome
 * @date 2020年 03月08日 16:35:58
 */
public class Student {

	private long studentId;

	private String studentName;

	private String studentAccount;

	private String studentPassword;

	private long instructorId;

	private String instructName;

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(String studentAccount) {
		this.studentAccount = studentAccount;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructName() {
		return instructName;
	}

	public void setInstructName(String instructName) {
		this.instructName = instructName;
	}
}
