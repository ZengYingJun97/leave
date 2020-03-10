package com.handsome.leave.dao;

import com.handsome.leave.entity.Instructor;
import com.handsome.leave.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentDaoTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentDao studentDao;

	@Test
	public void queryAll() {
		List<Student> students = studentDao.queryAll();
		logger.info("students = {}", students);
	}

	@Test
	public void queryByStudentId() {
		long studentId = 1L;
		Student student = studentDao.queryByStudentId(studentId);
		logger.info("student = {}", student);
	}

	@Test
	public void updateByStudent() {
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("123");
		int updateCount = studentDao.updateByStudent(student);
		logger.info("updateCount = {}", updateCount);
	}

	@Test
	public void insertByStudent() {
		Student student = new Student();
		student.setStudentName("123");
		student.setStudentAccount("123");
		student.setStudentPassword("123");
		Instructor instructor = new Instructor();
		instructor.setInstructorId(1);
		student.setInstructor(instructor);
		int insertCount = studentDao.insertByStudent(student);
		logger.info("insertCount = {}", insertCount);
	}
}