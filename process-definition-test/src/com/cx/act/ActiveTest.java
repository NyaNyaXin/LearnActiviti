package com.cx.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;

public class ActiveTest {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
		DeploymentBuilder createDeployment = repositoryService.createDeployment();
		createDeployment.addClasspathResource("test3.bpmn");
		Deployment deploy = createDeployment.deploy();
		
		//查询一个流程定义
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		//使用key对指定的流程定义惊醒中止操作
		repositoryService.suspendProcessDefinitionByKey(pd.getKey());
		//被终止的流程定义就不能在创建流程实例了，在创建的时候抛出异常
		RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
		runtimeService.startProcessInstanceByKey(pd.getKey());
	}
}
