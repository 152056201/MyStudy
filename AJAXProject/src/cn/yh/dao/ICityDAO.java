package cn.yh.dao;

import java.util.List;

import cn.yh.vo.City;

public interface ICityDAO {
	
	/**
	 * ����ʡ���г����г���
	 * @param pid ʡ��
	 * @return
	 * @throws Exception
	 */
	public List<City> findAllByPro(Integer pid) throws Exception; 

}
