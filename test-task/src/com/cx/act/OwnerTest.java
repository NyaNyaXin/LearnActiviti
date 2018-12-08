package com.cx.act;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;

public class OwnerTest {
	public static void main(String[] args) {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = engine.getTaskService();
		IdentityService identityService = engine.getIdentityService();
		User user = identityService.newUser(UUID.randomUUID().toString());
		user.setFirstName("测试用户");
		identityService.saveUser(user);
		Task task= taskService.newTask(UUID.randomUUID().toString());
		task.setName("测试任务");
		taskService.saveTask(task);
		taskService.addCandidateUser(task.getId(), user.getId());
		//设置任务的持有人
		taskService.setOwner(task.getId(), user.getId());
		
		//根据用户来查询他所持有的任务
		List<Task> list = taskService.createTaskQuery().taskOwner(user.getId()).list();
		for(Task t:list) {
			System.out.println(t.getName());
		}
		
		
	}
}
