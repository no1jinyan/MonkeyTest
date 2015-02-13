package com.bankht.monkey.mybatis.entity;

import java.io.Serializable;
import java.util.List;

public class CountryEntity implements Serializable {
	private static final long serialVersionUID = -4783137208897286569L;

	private List<CityEntity> cityList;
	
	private String code;
	private String name;
	private String continent;
	private String region;
	private int population;
	private double liftExpectancy;
	private int capital;
	private String headOfState;
	
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public List<CityEntity> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityEntity> cityList) {
		this.cityList = cityList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double getLiftExpectancy() {
		return liftExpectancy;
	}
	public void setLiftExpectancy(double liftExpectancy) {
		this.liftExpectancy = liftExpectancy;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
}
