package com.lexian.manager.goods.service;

import com.lexian.manager.goods.bean.Commodity;
import com.lexian.web.ResultHelper;

public interface CommodityService {
	
	public ResultHelper getCommodities(Integer pageNo);
	
	public ResultHelper getCommodityByName(String name);
	
	public ResultHelper getCommodityBycommodityNo(String commodityNo);
	
	public ResultHelper updateCommodity(Commodity commodity);
	
	public ResultHelper addCommodity(Commodity commodity);

	public ResultHelper getCommodityById(int id);
	
	
	public ResultHelper updateCommodityPicture(String commodityNo,String pictureUrl);
}
