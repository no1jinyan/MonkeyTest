package com.bankht.monkey.mybatis.entity;

import java.io.Serializable;

public class CityEntity implements Serializable {
	private static final long serialVersionUID = -1671559727800819205L;
	private CountryEntity countryEntity;
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CountryEntity getCountryEntity() {
		return countryEntity;
	}

	public void setCountryEntity(CountryEntity countryEntity) {
		this.countryEntity = countryEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public CityEntity() {
		// TODO Auto-generated constructor stub
	}

}
