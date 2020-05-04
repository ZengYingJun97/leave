package com.handsome.leave.service;

import org.activiti.engine.runtime.ProcessInstance;
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
	 * @param process 流程id
	 * @param variables 流程中的变量
	 * @return org.activiti.engine.task.Task
	 */
	ProcessInstance startProcess(String process, Map<String, Object> variables);

	/**
	 * 完成当前任务，并传入下一个节点的参数
	 * @date 2020/05/04 23:23:36
	 * @author handsome
	 * @param taskId
	 * @param variables
	 * @return void
	 */
	void completeTask(String taskId, Map<String, Object> variables);

	/**
	 * 根据流程名查询任务
	 * @date 2020/05/04 23:27:50
	 * @author handsome
	 * @param process
	 * @param assigneeName
	 * @param assignee
	 * @return java.util.List<org.activiti.engine.task.Task>
	 */
	List<Task> queryTask(String process, String assigneeName, String assignee);
}
