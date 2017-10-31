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
		Privilege menu12, menu13, menu14;
		menu12 = new Privilege("新建", "user_add", menu4);
		menu13 = new Privilege("删除", "user_delete", menu4);
		menu14 = new Privilege("修改", "user_edit", menu4);

		hibernateTemplate.save(menu12);
		hibernateTemplate.save(menu13);
		hibernateTemplate.save(menu14);
		
		/*//网上交流菜单
		Privilege menu15;
		menu15 = new Privilege("网上交流", null, null);
		
		//网上交流下面的子菜单
		Privilege menu16,menu17;
		menu16 = new Privilege("论汤", "forum_list", menu15);
		menu17 = new Privilege("论坛管理", "forum_managerList", menu15);*/
		
		
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
