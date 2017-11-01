package com.baidu.OA.install;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.OA.model.Privilege;
import com.baidu.OA.model.User;

@Component("installer")
public class Installer {
	HibernateTemplate hibernateTemplate;

	public void install() {
		// 创建超级管理员
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		String md5 = DigestUtils.md5Hex("admin");
		user.setPassword(md5);

		hibernateTemplate.save(user);
		
		// 初始化权限数据
		Privilege menu1, menu2, menu3, menu4;
		menu1 = new Privilege("系统管理", null, null);
		menu2 = new Privilege("岗位管理", "role_list", menu1);
		menu3 = new Privilege("部门管理", "department_list", menu1);
		menu4 = new Privilege("用户管理", "user_list", menu1);

		hibernateTemplate.save(menu1);
		hibernateTemplate.save(menu2);
		hibernateTemplate.save(menu3);
		hibernateTemplate.save(menu4);

		// 岗位管理下面的子权限
		Privilege menu5, menu6, menu7, menu8;
		menu5 = new Privilege("新建", "role_add", menu2);
		menu6 = new Privilege("删除", "role_delete", menu2);
		menu7 = new Privilege("修改", "role_edit", menu2);
		menu8 = new Privilege("设置权限", "role_privilege", menu2);

		hibernateTemplate.save(menu5);
		hibernateTemplate.save(menu6);
		hibernateTemplate.save(menu7);
		hibernateTemplate.save(menu8);

		// 部门管管理下面的子权限
		Privilege menu9, menu10, menu11;
		menu9 = new Privilege("新建", "department_add", menu3);
		menu10 = new Privilege("删除", "department_delete", menu3);
		menu11 = new Privilege("修改", "department_edit", menu3);

		hibernateTemplate.save(menu9);
		hibernateTemplate.save(menu10);
		hibernateTemplate.save(menu11);

		// 用户管理下面的子权限
		Privilege menu12, menu13, menu14,menu15;
		menu12 = new Privilege("新建", "user_add", menu4);
		menu13 = new Privilege("删除", "user_delete", menu4);
		menu14 = new Privilege("修改", "user_edit", menu4);
		menu15 = new Privilege("初始化密码", "user_initPassword", menu4);
		
		hibernateTemplate.save(menu12);
		hibernateTemplate.save(menu13);
		hibernateTemplate.save(menu14);
		hibernateTemplate.save(menu15);
		
		//网上交流菜单
		Privilege menu16;
		menu16 = new Privilege("网上交流", null, null);
		
		//网上交流下面的子菜单
		Privilege menu17,menu18;
		menu17 = new Privilege("论坛", "forum_list", menu16);
		menu18 = new Privilege("论坛管理", "forumManager_list", menu16);
		
		hibernateTemplate.save(menu16);
		hibernateTemplate.save(menu17);
		hibernateTemplate.save(menu18);
		
		//审批流转
		Privilege menu19;
		menu19 = new Privilege("审批流转", null, null);
		
		//审批流转下面的子菜单
		Privilege menu20,menu21,menu22,menu23,menu24;
		menu20 = new Privilege("审批流程管理", "flowManager_list", menu19);
		menu21 = new Privilege("表单模板管理", "templateManager_list", menu19);
		menu22 = new Privilege("起草申请", "flowApplication_list", menu19);
		menu23 = new Privilege("待我审批", "myTasks_list", menu19);
		menu24 = new Privilege("我的申请查询", "myApplication_list", menu19);
		 
		hibernateTemplate.save(menu19);
		hibernateTemplate.save(menu20);
		hibernateTemplate.save(menu21);
		hibernateTemplate.save(menu22);
		hibernateTemplate.save(menu23);
		hibernateTemplate.save(menu24);
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public static void main(String[] args) {
		// 初始化spring容器
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"beans.xml");
		// 从spring容器里面拿到Installer实例
		Installer installer = (Installer) factory.getBean("installer");
		// 执行初始化方法
		installer.install();
	}
}
