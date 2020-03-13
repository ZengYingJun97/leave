package com.handsome.leave.service.impl;

import com.handsome.leave.dao.StudentDao;
import com.handsome.leave.entity.Student;
import com.handsome.leave.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * StudentServiceImpl
 *
 * @author handsome
 * @date 2020年 03月13日 15:45:36
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	//验证账号前缀
	private final String accountSlat = "@#FDASDgads!%TGSD !@$!^&^@$#2";

	//验证账号前缀
	private final String passwordSlat = "Gdw3#%G$U$*&^$FEGSFHJWTESRQ1";

	private String getMD5(String pre, String data) {
		String base = pre + "/" + data;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	public Student login(Student student) {
		//获取账号md5
		student.setStudentAccount(getMD5(accountSlat, student.getStudentAccount()));
		student.setStudentPassword(getMD5(passwordSlat, student.getStudentPassword()));

		Student studnetSuccess = null;
		List<Student> students = studentDao.queryAll();
		for (Student s: students) {
			if (student.getStudentAccount().equals(s.getStudentAccount()) &&
					student.getStudentPassword().equals(s.getStudentPassword())) {
				studnetSuccess.setStudentId(s.getStudentId());
				studnetSuccess.setStudentAccount(s.getStudentAccount());
				studnetSuccess.setStudentName(s.getStudentName());
				studnetSuccess.setInstructor(s.getInstructor());
				break;
			}
		}

		return studnetSuccess;
	}

	@Override
	public Student getByStudentId(int studentId) {
		return studentDao.queryByStudentId(studentId);
	}
}
