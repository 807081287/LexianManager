package com.lexian.manager.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lexian.manager.shop.bean.Store;

public interface StoreDao {
	//Map<String,Object> params
    public List<Store> getAllStorePage(Map<String,Object> params);
    public void addStore(Store store);
    public void updateStore(Store store);                                                 
}
