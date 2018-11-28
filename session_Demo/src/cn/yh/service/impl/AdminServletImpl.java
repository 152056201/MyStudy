package cn.yh.service.impl;

import cn.yh.dao.factory.DaoFactory;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.service.IAdminService;
import cn.yh.vo.Admin;

public class AdminServletImpl implements IAdminService {
	DateBaseConnection dbc = new DateBaseConnection();
	@Override
	public boolean Login(Admin vo) throws Exception {
		try {
			return DaoFactory.getAdminInstance(this.dbc.getConn()).findLogin(vo);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

}
