package com.test.dao;

import com.test.ann.Component;
import com.test.ann.InvokeMethod;

@Component("annotatedClass")
public class AnnotatedClass {
	public AnnotatedClass(){
		System.out.println("AnnotatedClass has been inited");
	}
	@InvokeMethod
	public void saySomething(String str){
		System.out.println(str);
	}
	public void cantSaySomething(String str){
		System.out.println(str);
	}
}
