package com.cx.act;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestSingle {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		Group singleResult = identityService.createGroupQuery().groupName("Group_0").singleResult();
		System.out.println(singleResult.getName());
	}
}
