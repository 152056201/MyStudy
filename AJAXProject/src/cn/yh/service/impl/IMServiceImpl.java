package cn.yh.service.impl;

import cn.yh.dbc.DatabaseConnection;
import cn.yh.factory.DAOFactory;
import cn.yh.service.IMemberService;
import cn.yh.vo.Member;

public class IMServiceImpl implements IMemberService{
	DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public boolean checkMid(String mid) throws Exception {
		try{
			return DAOFactory.getIMemberDaoInstance(this.dbc.getConn()).findById(mid)==null;
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean insert(Member vo) throws Exception {
		try{
			if(DAOFactory.getIMemberDaoInstance(this.dbc.getConn()).findById(vo.getMid())==null) {
				return DAOFactory.getIMemberDaoInstance(this.dbc.getConn()).doCreate(vo);
				
			}
			return false;
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

}
