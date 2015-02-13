package com.bankht.monkey.mybatis;

import com.bankht.monkey.mybatis.dao.CityMapper;
import com.bankht.monkey.mybatis.entity.CityEntity;

public class CityController {  
	  
    private CityMapper cityMapper;  
       
    public CityMapper getCityMapper() {
		return cityMapper;
	}

	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	public void indexPage() {     
        CityEntity entity = cityMapper.getCity(2);   
    }     
}  
