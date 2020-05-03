package com.handsome.leave.service;

import org.activiti.engine.task.Task;

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
	 * 根据流程id生成流程实例
	 * @date 2020/05/03 19:04:49
	 * @author handsome
	 * @param definitionId 流程id
	 * @param variables 流程中的变量
	 * @return org.activiti.engine.task.Task
	 */        
	Task startProcess(String definitionId, Map<String, Object> variables);

	/**
	 * 完成当前任务，并传入下一个节点的参数
	 * @date 2020/05/03 23:53:46
	 * @author handsome
	 * @param taskId 任务id
 	 * @param assignee 委托人
	 * @return java.lang.String
	 */
	void completeTask(String taskId, String assignee);

	/**
	 * 根据流程名查询任务
	 * @date 2020/05/04 00:04:10
	 * @author handsome
	 * @param process 流程名
	 * @param assigneeName 委托人key
	 * @param assignee 委托人value
	 * @return java.util.List<org.activiti.engine.task.Task>
	 */
	List<Task> queryTask(String process, String assigneeName, String assignee);
}
