package com.baidu.OA.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller("processDefinationAction")
@Scope("prototype")
public class ProcessDefinationAction extends BaseAction {
	private static final long serialVersionUID = -867018450638431004L;

	private File zipFile;
	private String key;//用于接收参数key
	
	private String id;//用于接收显示图片请求的id
	private InputStream inputStream;//用于下载文件的stream

	/**
	 * 显示所有的流程定义（对于相同的key只显示最新版本）
	 * @return
	 */
	public String list() {
		List<ProcessDefinition> pdList = processDefinationService.findAllLatestVersionDefination();
		ActionContext.getContext().put("pdList", pdList);
		return "list";
	}
	
	/**
	 * 部署新的流程定义
	 * @return
	 */
	public String addUI() {
		return "addUI";
	}
	
	/**
	 * 执行 添加流程定义的具体操作
	 * @return
	 */
	public String add() {
		processDefinationService.deployByZipFile(zipFile);
		return "toList";
	}
	
	/**
	 * 删除包含相同key的所有得流程定义
	 * @return
	 */
	public String delete() {
		processDefinationService.deleteByKey(key);
		return "toList";
	}
	
	/**
	 * 查询流程定义的图片（显示最新版本的流程定义图片）
	 * @return
	 */
	public String showDifinationImage() {
		inputStream = processDefinationService.getResourceImageAsStreamById(id);
		return "showDifinationImage";
	}
	
	

	//-------------------
	public File getZipFile() {
		return zipFile;
	}

	public void setZipFile(File zipFile) {
		this.zipFile = zipFile;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
