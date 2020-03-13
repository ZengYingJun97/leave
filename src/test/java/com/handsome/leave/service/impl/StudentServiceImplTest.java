package com.handsome.leave.service.impl;

import com.handsome.leave.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentServiceImpl studentService;

	@Test
	public void login() {
		Student student = new Student();
		student.setStudentAccount("std0000001");
		student.setStudentPassword("123456");
		Student studentLogin = studentService.login(student);
		logger.info("studentLogin = {}", studentLogin);
	}

	@Test
	public void getByStudentId() {
		long studentId = 1l;
		Student student = studentService.getByStudentId(studentId);
		logger.info("student = {}", student);
	}
}