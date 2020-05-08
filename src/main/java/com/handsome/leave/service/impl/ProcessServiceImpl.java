package com.handsome.leave.service.impl;

import com.handsome.leave.service.ProcessService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ProcessService
 *
 * @author handsome
 * @date 2020年 05月04日 23:15:29
 */
@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Override
	public ProcessInstance startProcess(String process, Map<String, Object> variables) {
		return runtimeService.startProcessInstanceByKey(process, variables);
	}

	@Override
	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId);
	}

	@Override
	public List<Task> queryTask(String process, String assignee) {
		List<Task> taskList = taskService.createTaskQuery()
				.processDefinitionKey(process)
				.taskAssignee(assignee)
				.orderByTaskDueDate().asc()
				.list();
		return taskList;
	}
}
