package com.handsome.leave.dao;

import com.handsome.leave.entity.Instructor;
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
public class InstructorDaoTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InstructorDao instructorDao;

	@org.junit.Test
	public void queryAll() {
		List<Instructor> instructors = instructorDao.queryAll();
		logger.info("instructors = {}", instructors);
	}

	@org.junit.Test
	public void queryByInstructorId() {
		long instructId = 1L;
		Instructor instructor = instructorDao.queryByInstructorId(instructId);
		logger.info("instructor = {}", instructor);
	}

	@org.junit.Test
	public void updateByInstructor() {
		Instructor instructor = new Instructor();
		instructor.setInstructorId(1);
		instructor.setInstructorName("123");
		int updateCount = instructorDao.updateByInstructor(instructor);
		logger.info("updateCount = {}", updateCount);
	}

	@org.junit.Test
	public void insertByInstructor() {
		Instructor instructor = new Instructor();
		instructor.setInstructorName("123");
		instructor.setInstructorAccount("123");
		instructor.setInstructorPassword("123");
		int insertCount = instructorDao.insertByInstructor(instructor);
		logger.info("insertCount = {}", insertCount);
	}
}