package com.baidu.OA.service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.baidu.OA.dao.TemplateDao;
import com.baidu.OA.model.Template;

@Service("templateService")
public class TemplateService {
	private TemplateDao templateDao;

	@Resource(name = "templateDao")
	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	public List<Template> findAllTemplate() {
		return templateDao.findAll();
	}

	public void delete(Template model) {
		templateDao.delete(model);
	}

	public void edit(Template model, File upload) {
		// 根据传过来的id参数查询实体
		Template template = templateDao.getById(model.getId());

		// 给持久化对象设置DefinationName属性
		template.setDefinationName(model.getDefinationName());
		// 给持久化对象设置name属性
		template.setName(model.getName());

		// 如果上传了新的文件
		if (upload != null) {
			// 删除原文件
			File file = new File(template.getPath());
			if (file.exists()) {
				file.delete();
			}
			// 保存新上传的文件
			String path = saveUpload(upload);
			// 给持久化对象设置path属性
			template.setPath(path);
		}
	}

	public void add(Template model, File upload) {
		String path = saveUpload(upload);
		model.setPath(path);
		templateDao.save(model);
	}

	public String saveUpload(File upload) {
		String path = null;
		if (upload != null) {
			SimpleDateFormat format = new SimpleDateFormat("/yyyy-MM-dd/");
			String basePath = ServletActionContext.getServletContext()
					.getRealPath("/WEB-INF/jsp/downloadFiles");
			// 格式化 日期，以便用来作为文件夹的名称
			String datePath = format.format(new Date());
			path = basePath + datePath;
			File dir = new File(path);
			// 如果所指目录不存在的话，就穿件目录文件夹
			if (!dir.exists()) {
				// 使用mkdirs函数，如果父路径不存在的话也一并创建
				dir.mkdirs();
			}
			// 最后加的uuid是文件的名字，在做rename操作的时候，路径的最后一项就是剪切后文件的名称
			path = path + UUID.randomUUID();
			// 剪切文件
			upload.renameTo(new File(path));
		}
		return path;
	}

	public Template getById(int id) {

		return templateDao.getById(id);
	}
}
