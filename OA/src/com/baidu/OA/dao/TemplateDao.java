package com.baidu.OA.dao;

import com.baidu.OA.base.BaseDao;
import com.baidu.OA.model.Template;

public interface TemplateDao extends BaseDao<Template> {

	void delete(Template model);
	
}
