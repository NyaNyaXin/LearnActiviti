package com.cx.act;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class DeployeTest {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
		DeploymentBuilder createDeployment = repositoryService.createDeployment();
		createDeployment.addClasspathResource("test1.bpmn");
		createDeployment.deploy();
	}
}
