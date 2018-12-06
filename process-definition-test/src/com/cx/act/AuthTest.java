package com.cx.act;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;


public class AuthTest {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
		
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		User user = identityService.newUser(UUID.randomUUID().toString());
		user.setFirstName("CX");
		identityService.saveUser(user);
		
		
		DeploymentBuilder createDeployment = repositoryService.createDeployment();
		createDeployment.addClasspathResource("test4.bpmn");
		Deployment deploy = createDeployment.deploy();
		
		ProcessDefinition singleResult = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		repositoryService.addCandidateStarterUser(singleResult.getId(), user.getId());
		
		
		List<ProcessDefinition> defs = repositoryService.createProcessDefinitionQuery().startableByUser(user.getId()).list();
		for(ProcessDefinition df:defs) {
			System.out.println(df.getId());
		}
		
		
	}
}
