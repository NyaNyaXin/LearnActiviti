package com.cx.act;

import java.io.IOException;
import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class TextQuery {
	public static void main(String[] args) throws IOException {

		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
		DeploymentBuilder createDeployment = repositoryService.createDeployment();
		createDeployment.addClasspathResource("test_1.txt");
		Deployment deploy = createDeployment.deploy();
		
		//部署数据查询
		InputStream resourceAsStream = repositoryService.getResourceAsStream(deploy.getId(), "test_1.txt");
		int available = resourceAsStream.available();
		byte[] contents = new byte[available];
		resourceAsStream.read(contents);
		String result = new String(contents);
		System.out.println(result);
	}
}
