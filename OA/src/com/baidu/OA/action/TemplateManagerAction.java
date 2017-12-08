package com.baidu.OA.action;

import java.beans.Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.baidu.OA.base.ModelDrivenAction;
import com.baidu.OA.model.Template;
import com.opensymphony.xwork2.ActionContext;

@Controller("templateManagerAction")
@Scope("prototype")
public class TemplateManagerAction extends ModelDrivenAction<Template> {
	private static final long serialVersionUID = -6823123095170544061L;
	private File upload;
	private InputStream inputStream;

	/** 查询所有的模板 */
	public String list() {
		List<Template> templateList = templateService.findAllTemplate();
		ActionContext.getContext().put("templateList", templateList);
		return "list";
	}

	/** 删除模板文件 */
	public String delete() {
		templateService.delete(model);
		return "toList";
	}

	/** 编辑界面 */
	public String editUI() {
		// 准备回显的数据
		model = templateService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(model);

		List<ProcessDefinition> pdList = processDefinationService
				.findAllLatestVersionDefination();
		ActionContext.getContext().put("pdList", pdList);

		return "saveUI";
	}

	public String addUI() {
		List<ProcessDefinition> pdList = processDefinationService
				.findAllLatestVersionDefination();
		ActionContext.getContext().put("pdList", pdList);
		return "saveUI";
	}

	/** 修改 */
	public String edit() {
		templateService.edit(model, upload);
		return "toList";
	}

	/** 添加 */
	public String add() {
		templateService.add(model, upload);
		return "toList";
	}

	/** 下载 */
	public String download() {
		Template template = templateService.getById(model.getId());
		try {
			inputStream = new FileInputStream(new File(template.getPath()));
			String filename = URLEncoder.encode(template.getName(), "UTF-8");
			ActionContext.getContext().put("filename", filename);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "download";
	}

	// =====================================================================================
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
