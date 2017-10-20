package com.baidu.OA.util;

import javax.persistence.Entity;

public class ModelUtil {
	
	public static <T> String getTableName(Class<T> clazz) {
		String tableName = null;
		boolean isEntityAnnotationExists = clazz.isAnnotationPresent(Entity.class);
		if(isEntityAnnotationExists) {
			Entity anno = (Entity) clazz.getAnnotation(Entity.class);
			tableName = anno.name();
			
		}
		if(!tableName.trim().equals("")) {
			return tableName;
		}
		return clazz.getSimpleName();
	}
}
