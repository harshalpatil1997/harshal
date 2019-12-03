package com.training.beans;

public class MyUser {
	
	private String name,pass;

	public MyUser(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", pass=" + pass + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
