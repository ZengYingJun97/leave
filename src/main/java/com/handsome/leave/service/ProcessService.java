package com.handsome.leave.service;

import org.activiti.engine.task.Task;
import org.omg.CORBA.portable.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * ProcessService
 *
 * @author handsome
 * @date 2020年 04月09日 23:46:40
 */
public interface ProcessService {

	/**
	 * 通过流程id，以及流程部署xml部署流程
	 * @date 2020/04/09 23:51:56
	 * @author handsome
	 * @param flowId
	 * @param descriptionXml
	 * @param tenantId
	 * @param args
	 * @return java.lang.String
	 */        
	String deploy(String flowId, String descriptionXml, String tenantId, String... args);

	/**
	 * 通过流程资源部署流程
	 * @date 2020/04/09 23:57:47
	 * @author handsome
	 * @param name
	 * @param resourceName
	 * @param tenantId
	 * @return java.lang.String
	 */        
	String deployByResource(String name, String resourceName, String tenantId);

	/**
	 * 通过流程id和租户id生成流程
	 * @date 2020/04/10 00:00:29
	 * @author handsome
	 * @param definitionId
	 * @param tenantId
	 * @param variables
	 * @return org.activiti.engine.task.Task
	 */        
	Task startProcess(String definitionId, String tenantId, Map<String, Object> variables);

	/**
	 * 完成当前流程任务
	 * @date 2020/04/10 00:03:44
	 * @author handsome
	 * @param taskId
	 * @param tenantId
	 * @param btnName
	 * @param actionId
	 * @param variables
	 * @param nodeExecutor
	 * @return java.lang.String
	 */        
	String completeTask(String taskId, String tenantId, String btnName, String actionId, Map<String, Object> variables, List<Map<String, Object>> nodeExecutor) throws Exception;

	/**
	 * 撤回当前流程实例任务
	 * @date 2020/04/10 00:05:37
	 * @author handsome
	 * @param taskId
	 * @return void
	 */        
	void recallTask(String taskId) throws ApplicationException;

	/**
	 * 终止当前流程实例r任务 
	 * @date 2020/04/10 00:14:57
	 * @author handsome
	 * @param instanceId
	 * @return void
	 */        
	void suspendTask(String instanceId) throws Exception;
}
