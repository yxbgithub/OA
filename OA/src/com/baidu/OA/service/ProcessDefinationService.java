package com.baidu.OA.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

@Service("processDefinationService")
public class ProcessDefinationService {
	ProcessEngine processEngine;

	@Resource(name = "processEngine")
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	/**
	 * 查询所有流程定义的最新版本
	 * 
	 * @return
	 */
	public List<ProcessDefinition> findAllLatestVersionDefination() {
		// 查询所有的流程定义，以版本的升序排列（包含所有的版本）
		List<ProcessDefinition> all = processEngine.getRepositoryService()//
				.createProcessDefinitionQuery()//
				.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)//
				.list();
		// 用于存储最新的流程定义，对于map而言，一个key只允许有一个value，所以后加入的会覆盖先加入的
		LinkedHashMap<String, ProcessDefinition> latestDifination = new LinkedHashMap<String, ProcessDefinition>();
		for (ProcessDefinition pd : all) {
			latestDifination.put(pd.getKey(), pd);
		}

		return new ArrayList<ProcessDefinition>(latestDifination.values());
	}

	/**
	 * 以zip形式部署流程定义
	 * 
	 * @param zipFile
	 */
	public void deployByZipFile(File zipFile) {
		ZipInputStream zipInput = null;
		// 准备
		try {
			zipInput = new ZipInputStream(new FileInputStream(zipFile));
			// 部署
			processEngine.getRepositoryService()//
					.createDeployment()//
					.addResourcesFromZipInputStream(zipInput)//
					.deploy();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (zipInput != null) {
				try {
					zipInput.close();
					zipInput = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 根据指定的key删除所有包含该key的版本
	 * 
	 * @param key
	 */
	public void deleteByKey(String key) {
		try {
			key = new String(key.getBytes("iso8859-1"), "utf-8");// 手动转码，解决url中中文乱码的问题
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 准备：根据指定的key查询出所有的版本流程定义
		List<ProcessDefinition> pd = processEngine.getRepositoryService()//
				.createProcessDefinitionQuery()//
				.processDefinitionKey(key)//
				.list();
		// 循环删除
		for (ProcessDefinition pd1 : pd) {
			processEngine.getRepositoryService()//
					.deleteDeploymentCascade(pd1.getDeploymentId());
		}
	}

	public InputStream getResourceImageAsStreamById(String id) {
		InputStream in = null;
		try {
			id = new String(id.getBytes("iso8859-1"), "utf-8");// 手动转码，解决url中中文乱码的问题
			// 根据id查询流程定义
			ProcessDefinition pd = processEngine.getRepositoryService()//
					.createProcessDefinitionQuery()//
					.processDefinitionId(id)//
					.uniqueResult();
			// 返回流
			in = processEngine.getRepositoryService()//
					.getResourceAsStream(pd.getDeploymentId(),
							pd.getImageResourceName());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return in;
	}

}
