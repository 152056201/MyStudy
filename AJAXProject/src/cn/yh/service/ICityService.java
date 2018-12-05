package cn.yh.service;

import java.util.List;

import cn.yh.vo.City;

public interface ICityService {
	public List<City> findAll(Integer pid) throws Exception;
}
