package com.cx.act;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class SaveGroup {
	public static void main(String[] args) {
		//��ȡĬ�ϵ���������
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		//��ȡ��ݷ���
		IdentityService identityService = defaultProcessEngine.getIdentityService();
		for (int i = 0; i < 10; i++) {
			//ʹ����ݷ��񴴽�һ����
			Group group = identityService.newGroup(String.valueOf(i));
			//�������һЩ����
			group.setName("Group_"+i);
			group.setType("TYPE_"+i);
			//���� 
			identityService.saveGroup(group);
		}
		defaultProcessEngine.close();
		System.exit(0);
	}
}
