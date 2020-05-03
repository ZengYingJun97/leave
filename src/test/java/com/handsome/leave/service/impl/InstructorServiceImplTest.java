package com.handsome.leave.service.impl;

import com.handsome.leave.entity.Instructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InstructorServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InstructorServiceImpl instructorService;

	@Test
	public void login() {
		Instructor instructor = new Instructor();
		instructor.setInstructorAccount("ins0000001");
		instructor.setInstructorPassword("123456");
		Instructor instructorLogin = instructorService.login(instructor);
		logger.info("instructorLogin = {}", instructorLogin);
	}

	@Test
	public void getByInstructorId() {
		long instructorId = 1L;
		Instructor instructor = instructorService.getByInstructorId(instructorId);
		logger.info("instructor = {}", instructor);
	}
}