package com.bankht.monkey.mybatis.dao;

import com.bankht.monkey.mybatis.entity.CountryEntity;

public interface CountryMapper {
	public CountryEntity getCountry(String code);  
}
