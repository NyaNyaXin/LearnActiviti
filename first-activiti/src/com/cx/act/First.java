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
		//�洢����
		RepositoryService repositoryService = engine.getRepositoryService();
		//����ʱ����
		RuntimeService runtimeService = engine.getRuntimeService();
		//�������
		TaskService taskService = engine.getTaskService();
		
		//����һ������
		repositoryService.createDeployment().addClasspathResource("first.bpmn").deploy();
		//����һ������
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
		
		//��ͨԱ����д�����ٵ�����
		Task singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("��ǰ���̽ڵ㣺"+singleResult.getName());
		taskService.complete(singleResult.getId());
		
		//�����������
		singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("��ǰ���̽ڵ㣺"+singleResult.getName());
		taskService.complete(singleResult.getId());
		
		//���̽���
		singleResult = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		System.out.println("��ǰ���̽ڵ㣺"+singleResult);
		//���̹ر�
		engine.close();
		System.exit(0);
	}
}
 