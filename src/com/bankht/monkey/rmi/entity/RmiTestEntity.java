package com.bankht.monkey.rmi.entity;

import java.io.Serializable;

public class RmiTestEntity implements Serializable{
	private static final long serialVersionUID = 3587741744152502923L;
	private String name;
	private String password;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
