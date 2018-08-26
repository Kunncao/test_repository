package com.test.dao;

import com.test.ann.Column;
import com.test.ann.Table;

@Table(value="hello")
public class User {
	@Column("id")
	private int id;
	@Column("name")
	private String name;
	@Column("age")
	private int age;
	@Column("email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
