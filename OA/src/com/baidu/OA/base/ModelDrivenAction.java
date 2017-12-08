package com.baidu.OA.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.baidu.OA.model.User;
import com.baidu.OA.service.DepartmentService;
import com.baidu.OA.service.ForumService;
import com.baidu.OA.service.PrivilegeService;
import com.baidu.OA.service.ReplyService;
import com.baidu.OA.service.RoleService;
import com.baidu.OA.service.TopicService;
import com.baidu.OA.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 该类继承自BaseAction，额外提供了ModelDriven支持
 * @author jack
 *
 * @param <T>
 */
public class ModelDrivenAction<T> extends BaseAction implements ModelDriven<T>{
	protected T model;

	public ModelDrivenAction() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			 model = (T) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		return model;
	}
	
	
}

