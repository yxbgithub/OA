package com.baidu.OA.daoImpl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.baidu.OA.base.BaseDaoImpl;
import com.baidu.OA.dao.ApproveInfoDao;
import com.baidu.OA.model.ApproveInfo;
import com.baidu.OA.util.QueryHelper;

@Repository("approveInfoDao")
public class ApproveInfoDaoImpl extends BaseDaoImpl<ApproveInfo> implements ApproveInfoDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<ApproveInfo> approvedHistory(QueryHelper queryHelper) {
		final String queryListString = queryHelper.getQueryListString();
		final List<Object> parameters = queryHelper.getParameters();
		
		
		List<ApproveInfo> approInfos = (List<ApproveInfo>) this.getHinernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				if(0 == parameters.size())
					return Collections.EMPTY_LIST;
				Query query = session.createQuery(queryListString);
				for(int i=0; i<parameters.size(); i++) {
					query.setParameter(i, parameters.get(i));
				}
				return query.list();
			}
		});
		return approInfos;
	}
	
}
