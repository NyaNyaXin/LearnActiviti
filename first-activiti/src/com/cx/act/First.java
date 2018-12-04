package com.cx.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class First {
	public static void main(String[] args) throws Exception {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		//存储服务
		RepositoryService repositoryService = engine.getRepositoryService();
		//运行时服务
		RuntimeService runtimeService = engine.getRuntimeService();
		//任务服务
		TaskService taskService = engine.getTaskService();
		
		//部署一个流程
		repositoryService.createDeployment().addClasspathResource("first.bpmn").deploy();
		//开启一个流程
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
		
		//普通员工填写完成请假的任务
		Task singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("当前流程节点："+singleResult.getName());
		taskService.complete(singleResult.getId());
		
		//经理审核任务
		singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("当前流程节点："+singleResult.getName());
		taskService.complete(singleResult.getId());
		
		//流程结束
		singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("当前流程节点："+singleResult);
		//流程关闭
		engine.close();
		System.exit(0);
	}
}
 