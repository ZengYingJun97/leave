package com.handsome.leave.entity;

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

	private Instructor instructor;

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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", studentName='" + studentName + '\'' +
				", studentAccount='" + studentAccount + '\'' +
				", studentPassword='" + studentPassword + '\'' +
				", instructor=" + instructor +
				'}';
	}
}
