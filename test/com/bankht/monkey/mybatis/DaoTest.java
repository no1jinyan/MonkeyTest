package com.bankht.monkey.mybatis;

import java.util.Calendar;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankht.monkey.mybatis.dao.CityMapper;
import com.bankht.monkey.mybatis.dao.CountryMapper;
import com.bankht.monkey.mybatis.dao.StudentMapper;
import com.bankht.monkey.mybatis.entity.CityEntity;
import com.bankht.monkey.mybatis.entity.CountryEntity;
import com.bankht.monkey.mybatis.entity.StudentEntity;

public class DaoTest extends TestCase {
	private ApplicationContext context;

	protected void setUp() throws Exception {
		super.setUp();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCity() {
		CityMapper cityMapper = (CityMapper) context
				.getBean("cityMapper");
		
		CityEntity city = cityMapper.getCity(2);
		city.getCountryEntity();
		System.out.println(city.getCountryEntity().getPopulation());

	}
	
	public void testCountry(){
		CountryMapper countryMapper = (CountryMapper) context.getBean("countryMapper");
		
		CountryEntity country = countryMapper.getCountry("USA");
		
		System.out.println(country.getHeadOfState());
	}
	
	public void testStudent(){
		StudentMapper studentMapper = (StudentMapper) context.getBean("studentMapper");
		
		//select
		StudentEntity student = studentMapper.getStudent(1);
		
		System.out.println(student.getName());
		
		//delete
		studentMapper.deleteStudent(student);
		
		
		//insert
		student.setName("cloneJinyan");
		
		Calendar date = Calendar.getInstance();
		date.set(1981, 1, 3);
		
		student.setBirthday(date.getTime());
		
		studentMapper.insertStudent(student);
	}

}
