package com.cx.act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestListPage {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		List<Group> list = identityService.createGroupQuery().listPage(0, 5);
		for(Group g:list) {
			System.out.println(g.getName() );
		}
		long count = identityService.createGroupQuery().count();
		System.out.println(count);
	}
}
