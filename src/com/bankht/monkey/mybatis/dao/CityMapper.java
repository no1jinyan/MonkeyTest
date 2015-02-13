package com.bankht.monkey.mybatis.dao;

import java.util.List;

import com.bankht.monkey.mybatis.entity.CityEntity;

public interface CityMapper {
	public CityEntity getCity(int cityId);  
    
    public List<CityEntity> getCityAll();  
      
    public void insertCity(CityEntity entity);  
      
    public void deleteCity(CityEntity entity);  
      
    public void updateCity(CityEntity entity);  
}
