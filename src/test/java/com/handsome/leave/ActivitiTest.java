package com.handsome.leave;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ActivitiTest
 *
 * @author handsome
 * @date 2020年 05月08日 23:55:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {

	@Test
	public void deploy(){
		//创建ProcessEngineConfiguration对象
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		//创建ProcessEngine对象
		ProcessEngine processEngine = configuration.buildProcessEngine();
		//得到RepositoryService实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//进行部署
		Deployment deployment = repositoryService.createDeployment()
				.addClasspathResource("processes/leave.bpmn")
				.addClasspathResource("processes/leave.png")
				.deploy();

		System.out.println(deployment.getName());
		System.out.println(deployment.getId());
	}
}
