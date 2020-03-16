package com.handsome.leave.service.impl;

import com.handsome.leave.dao.InstructorDao;
import com.handsome.leave.entity.Instructor;
import com.handsome.leave.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


/**
 * InstructorServiceImpl
 *
 * @author handsome
 * @date 2020年 03月16日 23:10:33
 */
@PropertySource("classpath:config.properties")
@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDao instructorDao;

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
	public Instructor login(Instructor instructor) {
		Instructor instructorSuccess = null;
		List<Instructor> instructorList = instructorDao.queryAll();
		for (Instructor i: instructorList) {
			if (instructor.getInstructorAccount().equals(i.getInstructorAccount()) &&
					instructor.getInstructorPassword().equals(i.getInstructorPassword())) {
				instructorSuccess = new Instructor();
				instructorSuccess.setInstructorId(i.getInstructorId());
				instructorSuccess.setInstructorAccount(getMD5(accountSlat, i.getInstructorAccount()));
				instructorSuccess.setInstructorPassword(getMD5(passwordSlat, i.getInstructorPassword()));
				instructorSuccess.setInstructorName(i.getInstructorName());
				break;
			}
		}
		return instructorSuccess;
	}

	@Override
	public Instructor getByInstructorId(long instructorId) {
		return instructorDao.queryByInstructorId(instructorId);
	}
}
