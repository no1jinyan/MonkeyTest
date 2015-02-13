/**
 * 
 */
package com.bankht.monkey.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class StudentEntity implements Serializable {
	private static final long serialVersionUID = -461018827484705805L;
	
	private int id;
	private String name;
	private String email;
	private String password;
	private Date birthday;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
