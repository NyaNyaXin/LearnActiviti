package com.cx.act;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

public class CandidateTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = engine.getTaskService();
		IdentityService identityService = engine.getIdentityService();
		User user = identityService.newUser(UUID.randomUUID().toString());
		user.setFirstName("�����û�");
		identityService.saveUser(user);
		Task task= taskService.newTask(UUID.randomUUID().toString());
		task.setName("��������");
		taskService.saveTask(task);
		taskService.addCandidateUser(task.getId(), user.getId());
		
		List<Task> list = taskService.createTaskQuery().taskCandidateUser(user.getId()).list();
		for(Task t:list) {
			System.out.println(t.getName());
		}
	}
}
