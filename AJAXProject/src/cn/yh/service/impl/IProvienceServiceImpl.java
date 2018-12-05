package cn.yh.service.impl;

import java.util.List;

import cn.yh.dbc.DatabaseConnection;
import cn.yh.factory.DAOFactory;
import cn.yh.service.IProviecneService;
import cn.yh.vo.Provinces;

public class IProvienceServiceImpl implements IProviecneService{
	DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public List<Provinces> list() throws Exception {
		try {
			return DAOFactory.getIProviencesDaoInstance(this.dbc.getConn()).findAll();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}
	/*public static void main(String[] args) {
		IProvienceServiceImpl ii = new IProvienceServiceImpl();
		try {
			List<Provinces> list = ii.list();
			for (Provinces provinces : list) {
				System.out.println(provinces.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
