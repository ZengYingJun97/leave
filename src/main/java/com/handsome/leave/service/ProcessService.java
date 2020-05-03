package com.handsome.leave.service;

import org.activiti.engine.task.Task;

import java.util.Map;

/**
 * ProcessService
 *
 * @author handsome
 * @date 2020年 04月09日 23:46:40
 */
public interface ProcessService {

	/**
	 * 根据流程id生成流程实例
	 * @date 2020/05/03 19:04:49
	 * @author handsome
	 * @param definitionId 流程id
	 * @param variables 流程中的变量
	 * @return org.activiti.engine.task.Task
	 */        
	Task startProcess(String definitionId, Map<String, Object> variables);

	String completeTask(String taskId, String )
}
