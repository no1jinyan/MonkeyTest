package com.bankht.monkey.mybatis.dao;

import com.bankht.monkey.mybatis.entity.StudentEntity;

public interface StudentMapper {
	public StudentEntity getStudent(int id);
	
	public void insertStudent(StudentEntity studentEntity);
	
	public void deleteStudent(StudentEntity studentEntity);
	
	public void updateStudent(StudentEntity studentEntity);
}
