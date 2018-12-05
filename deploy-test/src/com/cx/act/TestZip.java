package com.cx.act;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class TestZip {
	public static void main(String[] args) throws Exception{
		//创建流程处理引擎
		ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
		//获取仓库服务
		RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
		
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		FileInputStream fin = new FileInputStream(new File("resource/Data.zip"));
		ZipInputStream zis = new ZipInputStream(fin);
		deploymentBuilder.addZipInputStream(zis);
		deploymentBuilder.deploy();
	}
}
