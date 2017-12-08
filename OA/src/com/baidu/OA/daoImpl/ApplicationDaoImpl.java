package com.baidu.OA.daoImpl;

import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.ApplicationDao;
import com.baidu.OA.model.Application;

@Repository("applicationDao")
public class ApplicationDaoImpl extends BaseDaoImpl<Application> implements ApplicationDao {

}
