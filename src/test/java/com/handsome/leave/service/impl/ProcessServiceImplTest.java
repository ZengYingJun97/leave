package com.handsome.leave.service.impl;

import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessServiceImplTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private  ProcessServiceImpl processService;

	@Test
	public void startProcess() {
		String process = "leave_process";
		Map<String, Object> map = new HashMap<>();
		map.put("studentId", 1);
		ProcessInstance instance = processService.startProcess(process, map);
		logger.info("instance = {}", instance.getId());
	}

	@Test
	public void completeTask() {
	}

	@Test
	public void queryTask() {
	}
}