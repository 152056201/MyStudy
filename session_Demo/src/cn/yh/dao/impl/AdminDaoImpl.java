package cn.yh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.yh.dao.IAdminDAO;
import cn.yh.vo.Admin;

public class AdminDaoImpl implements IAdminDAO{
	private Connection conn;
	private PreparedStatement ps;
	public AdminDaoImpl(Connection conn){
		this.conn = conn;
	}
	@Override
	public boolean findLogin(Admin vo) throws Exception {
		String sql = " select count(id) from admin where id=? and password=? ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, vo.getId());
		this.ps.setString(2, vo.getPassword());
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			if(rs.getInt(1)>0) {
				return true;
			}
			
		}
		return false;
	}

}
