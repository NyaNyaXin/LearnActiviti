package com.cx.act;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class SaveGroup {
	public static void main(String[] args) {
		//获取默认的流程引擎
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		//获取身份服务
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		for (int i = 0; i < 10; i++) {
			//使用身份服务创建一个组
			Group group = identityService.newGroup(String.valueOf(i));
			//设置组的一些属性
			group.setName("Group_"+i);
			group.setType("TYPE_"+i);
			//保存 
			identityService.saveGroup(group);
		}
		defaultProcessEngine.close();
		System.exit(0);
	}
}
