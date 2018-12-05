package cn.yh.dao;

import java.util.List;

import cn.yh.vo.City;

public interface ICityDAO {
	
	/**
	 * 根据省份列出所有城市
	 * @param pid 省份
	 * @return
	 * @throws Exception
	 */
	public List<City> findAllByPro(Integer pid) throws Exception; 

}
