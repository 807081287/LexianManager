package com.lexian.manager.goods.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lexian.manager.goods.bean.Commodity;
import com.lexian.manager.goods.dao.CommodityDao;
import com.lexian.manager.goods.service.CommodityService;
import com.lexian.utils.Constant;
import com.lexian.web.Page;
import com.lexian.web.ResultHelper;

@Service
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commodityDao;

	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	@Override
	public ResultHelper getCommodities(Integer pageNo) {
		Page page = new Page();

		if (pageNo != null) {
			page.setPageNo(pageNo);
		}
		page.setTotalSize(commodityDao.getCountCommodity());
		Map<String, Object> params = new HashMap<>();
		params.put("page", page);
		List<Commodity> orderssWithStore = commodityDao.getCommodities(params);
		page.setData(orderssWithStore);

		ResultHelper result = new ResultHelper(Constant.code_success, page);

		return result;
	}

	@Override
	public ResultHelper getCommodityByName(String name) {
		
		Commodity commodity=commodityDao.getCommodityByName(name);
		
		if (commodity != null) {
			return new ResultHelper(Constant.code_success,commodity);
		} else {
			return new ResultHelper(Constant.code_entity_not_found,commodity);
		}
	}

	@Override
	public ResultHelper getCommodityBycommodityNo(String commodityNo) {
		Commodity commodity=commodityDao.getCommodityBycommodityNo(commodityNo);
		if (commodity != null) {
			return new ResultHelper(Constant.code_success,commodity);
		} else {
			return new ResultHelper(Constant.code_entity_not_found,commodity);
		}
	}

	@Override
	public ResultHelper updateCommodity(Commodity commodity) {
		Date time = new Date();
		commodity.setUpdateTime(time);
		System.out.println(commodity.getUpdateTime());
		commodityDao.updateCommodity(commodity);
		return new ResultHelper(Constant.code_success);
	}

	@Override
	public ResultHelper addCommodity(Commodity commodity) {
		Date time = new Date();
		commodity.setCreateTime(time);
		commodity.setStates(1);
		commodityDao.addCommodity(commodity);
		commodityDao.addCommodityPicture(commodity.getCommodityNo(),commodity.getPictureUrl());
		System.out.println(commodity.getCommodityNo()+commodity.getPictureUrl());
		System.out.println(commodity.getCreateTime());
		return new ResultHelper(Constant.code_success);
	}

	@Override
	public ResultHelper getCommodityById(int id) {
		Commodity commodity = commodityDao.getCommodityById(id);
		if (commodity != null) {
			return new ResultHelper(Constant.code_success,commodity);
		} else {
			return new ResultHelper(Constant.code_entity_not_found,commodity);
		}
		
	}

	@Override
	public ResultHelper updateCommodityPicture(String commodityNo, String pictureUrl) {
		commodityDao.updateCommodityPicture(commodityNo, pictureUrl);
		return new ResultHelper(Constant.code_success);
	}

}
