package com.handsome.leave.dao;

/**
 * ActivitiTest
 *
 * @author handsome
 * @date 2020年 05月02日 23:39:16
 */

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

	@Autowired
	RepositoryService repositoryService;

	@Autowired
	RuntimeService runtimeService;

	@Autowired
	TaskService taskService;

	@Test
	public void contextLoad() {
		System.out.println("Number of process definitions : "
			+ repositoryService.createDeploymentQuery().count());
		System.out.println("Number of tasks : "
			+ taskService.createTaskQuery().count());
		Map<String, Object> map = new HashMap<>();
		map.put("studentId", 1);
		map.put("instructorId", 1);
		runtimeService.startProcessInstanceByKey("myProcess_1", map);
		System.out.println("Number of tasks after process start : "
				+ taskService.createTaskQuery().count());
	}
}
