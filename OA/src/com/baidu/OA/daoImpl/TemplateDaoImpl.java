package com.baidu.OA.daoImpl;

import java.io.File;

import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.TemplateDao;
import com.baidu.OA.model.Template;

@Repository("templateDao")
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements TemplateDao {

	@Override
	public void delete(Template model) {
		//删除实体
		Template template = (Template) getHinernateTemplate().get(Template.class, model.getId());
		getHinernateTemplate().delete(template);
		//删除磁盘对应的文件
		File file = new File(template.getPath());
		if(file.exists()) {
			file.delete();
		}
	}

}
