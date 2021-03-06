package com.handsome.leave.service.impl;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
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
		String taskId = "4416324f-9075-11ea-9012-a697a309d92d";
		Map<String, Object> map = new HashMap<>();
		map.put("instructorId", 1);
		processService.completeTask(taskId, map);
	}

	@Test
	public void queryTask() {
		logger.info("start queryTask");
		String process = "leave_process";
		String assignee = "2";
		List<Task> taskList = processService.queryTask(process, assignee);
		for (Task task: taskList) {
			logger.info("taskId = {}", task.getId());
		}
		logger.info("end queryTask");
	}
}