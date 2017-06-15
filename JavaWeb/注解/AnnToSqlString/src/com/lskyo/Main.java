package com.lskyo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Filter f1 = new Filter();
		f1.setId(10);

		Filter f2 = new Filter();
		f2.setUserName("lucy");
		f2.setId(15);

		Filter f3 = new Filter();
		f3.setEmail("liu@sina.com,zh@163.com,7777@qq.com");
		
		Filter2 f21 = new Filter2();
		f21.setId(20);
		f21.setLeader("john");

		String sql1 = query(f1);
		String sql2 = query(f2);
		String sql3 = query(f3);
		String sql4 = query(f21);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		System.out.println(sql4);
	}

	private static String query(Object obj) {

		StringBuilder sb = new StringBuilder();
		Class c = obj.getClass();
		if (!c.isAnnotationPresent(Table.class)) {
			return null;
		}
		Table t = (Table) c.getAnnotation(Table.class);
		String tableName = t.value();
		sb.append("select * from ").append(tableName).append(" where 1=1");
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			boolean fExists = field.isAnnotationPresent(Column.class);
			if (!fExists) {
				continue;
			}
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + 
					fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = c.getMethod(getMethodName);
				fieldValue = getMethod.invoke(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(fieldValue == null || ((fieldValue instanceof Integer) && (((int)fieldValue) == 0))){
				continue;
			}
			sb.append(" and ").append(fieldName);
			if(fieldValue instanceof String){
				if(((String)fieldValue).contains(",")){
					String[] values = ((String)fieldValue).split(",");
					sb.append(" in(");
					for (String string : values) {
						sb.append("'").append(string).append("',");
					}
					sb.delete(sb.length()-1, sb.length());
					sb.append(")");
				}else{
					sb.append("=").append("'").append(fieldValue).append("'");
				}
			}else if(fieldValue instanceof Integer){
				sb.append("=").append(fieldValue);
			}
		}

		return sb.toString();
	}

}

















