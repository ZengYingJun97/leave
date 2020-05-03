package com.handsome.leave.service.impl;

import com.handsome.leave.dao.StudentDao;
import com.handsome.leave.entity.Student;
import com.handsome.leave.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * StudentServiceImpl
 *
 * @author handsome
 * @date 2020年 03月13日 15:45:36
 */
@PropertySource("classpath:config.properties")
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Value("${accountSlat}")
	private String accountSlat;

	@Value("${passwordSlat}")
	private String passwordSlat;

	private String getMD5(String pre, String data) {
		String base = pre + "/" + data;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Override
	public Student login(Student student) {
		Student studnetSuccess = null;
		List<Student> students = studentDao.queryAll();
		for (Student s: students) {
			if (student.getStudentAccount().equals(s.getStudentAccount()) &&
					student.getStudentPassword().equals(s.getStudentPassword())) {
				studnetSuccess = new Student();
				studnetSuccess.setStudentId(s.getStudentId());
				studnetSuccess.setStudentAccount(getMD5(accountSlat, s.getStudentAccount()));
				studnetSuccess.setStudentPassword(getMD5(passwordSlat, s.getStudentPassword()));
				studnetSuccess.setStudentName(s.getStudentName());
				studnetSuccess.setInstructor(s.getInstructor());
				break;
			}
		}
		return studnetSuccess;
	}

	@Override
	public Student getByStudentId(long studentId) {
		return studentDao.queryByStudentId(studentId);
	}
}
