package com.test.service;

import java.lang.reflect.Method;

import com.test.ann.Component;
import com.test.ann.InvokeMethod;

public class Test {
	public static void main(String[] args) {
		/*
		 * Query q = new Query(); User u = new User(); u.setAge(11);
		 * u.setEmail("fcandroidme@gmail.com"); u.setId(2);
		 * u.setName("Alan Wake"); System.out.println(q.query(u));
		 */
		try {
			Class c = Class.forName("com.test.dao.AnnotatedClass");

			boolean hasAnnotations = c.isAnnotationPresent(Component.class);
			
			if(hasAnnotations){
				Component component = (Component)c.getAnnotation(Component.class);
				String objectName = component.value();
				
				String str="say hello";
				for(Method method:c.getMethods()){
					if(method.isAnnotationPresent(InvokeMethod.class)){
						method.invoke(c.newInstance(), str);
					}
					
				}
				
			}else{
				System.out.println("no annotation");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
