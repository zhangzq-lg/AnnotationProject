package com.lg.gz.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.lg.gz.annotation.Column;
import com.lg.gz.annotation.Table;

public class UserDao {

	public String query(Object obj) {
		StringBuilder sb = new StringBuilder();
		// 1.获取到class
		Class c = obj.getClass();
		// 2.获取Table（注解）的名字，“当前类是否有制定的注解”
		boolean exists = c.isAnnotationPresent(Table.class);
		if (!exists) {
			return null;
		}
		Table t = (Table) c.getAnnotation(Table.class);
		// 获取到表名称
		String table = t.value();
		sb.append("select * from ").append(table).append(" where 1=1");
		// 3.遍历所有的字段
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			// 4.处理每个字段对应的sql
			// 4.1 获取字段名
			boolean fExists = field.isAnnotationPresent(Column.class);
			if (!fExists) {
				continue;
			}
			Column column = (Column) field.getAnnotation(Column.class);
			String columnName = column.value();
			// 4.2 获取字段值，通过反射getter方法获取
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = c.getMethod(getMethodName, null);
				fieldValue = getMethod.invoke(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 4.3 拼接sql语句
			if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
				continue;
			}
			sb.append(" and ").append(columnName);
			// 判断是否有逗号，有则进行拆分
			if (fieldValue instanceof String) {
				if (((String) fieldValue).contains(",")) {
					String[] fieldValues = ((String) fieldValue).split(",");
					sb.append(" in(");
					for (String fieldValue1 : fieldValues) {
						// in('asfdasj','225545','1234dasfas')拼接成这种形式
						sb.append("'").append(fieldValue1.trim()).append("'").append(",");
					}
					sb.deleteCharAt(sb.length() - 1).append(")");
				}
				// 没有则进行正常拼接
				else {
					sb.append("=").append("'").append(fieldValue).append("'");
				}
			} else if (fieldValue instanceof Integer) {
				sb.append("=").append(fieldValue);
			}
			// sb.append(" and
			// ").append(fieldName).append("=").append(fieldValue);
		}

		return sb.toString();
	}

}
