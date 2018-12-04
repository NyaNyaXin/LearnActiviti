package com.cx.act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestList {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		List<Group> list = identityService.createGroupQuery().list();
		for(Group g:list) {
			System.out.println(g.getName() );
		}
	}
}
