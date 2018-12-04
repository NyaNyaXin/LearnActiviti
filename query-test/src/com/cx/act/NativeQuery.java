package com.cx.act;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class NativeQuery {
	public static void main(String[] args) {
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		List<Group> list = identityService.createNativeGroupQuery().sql("SELECT * FROM ACT_ID_GROUP where NAME_ = #{name}").parameter("name", "Group_2").list();
		System.out.println(list.size());
	}
}
