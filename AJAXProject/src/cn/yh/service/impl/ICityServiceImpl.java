package cn.yh.service.impl;

import java.util.List;

import cn.yh.dbc.DatabaseConnection;
import cn.yh.factory.DAOFactory;
import cn.yh.service.ICityService;
import cn.yh.vo.City;

public class ICityServiceImpl implements ICityService{
	DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public List<City> findAll(Integer pid) throws Exception {
		try {
			return DAOFactory.getICityDaoInstance(this.dbc.getConn()).findAllByPro(pid);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}
	/*public static void main(String[] args) {
		ICityServiceImpl ic = new ICityServiceImpl();
		try {
			List<City> list = ic.findAll(6);
			for (City city : list) {
				System.out.println(city.getCity());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
