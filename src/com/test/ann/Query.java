package com.test.ann;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.User;

public class Query {
	private String tablename;
	private List<String> fieldvalue = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	public String query(User u) {
		try {
			// 1.类加载器加载被注解类
			Class<?> c = Class.forName("com.test.dao.User");
			// 2.找到 类上的注解
			@SuppressWarnings("unchecked")
			boolean isexist = c.isAnnotationPresent(Table.class);
			// 3.得到注解
			if (isexist) {
				@SuppressWarnings("unchecked")
				Table tb = (Table) c.getAnnotation(Table.class);
				tablename = tb.value();
			} else {
				System.out.println("null");
			}
			// 4.得到类的所有属性对象
			Field[] farray = c.getDeclaredFields();
			for (Field field : farray) {
				String fieldname = field.getName();
				// 5.方法调用
				String methodname = "get" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
				System.out.println(methodname);
				try {
					Method method = c.getMethod(methodname);
					try {
						// invoke(调用方法的对象)
						Object ob = method.invoke(u);
						if (ob instanceof String) {
							fieldvalue.add((String) ob);
						} else {
							fieldvalue.add(ob + "");
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		fieldvalue.forEach((String s) -> System.out.println(s));
		// 拼接字符串
		String querystring = "SELECT * FROM " + tablename.substring(0, 1).toUpperCase() + tablename.substring(1)
				+ " WHERE 1=1";
		return querystring;
	}
}
