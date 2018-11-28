package cn.yh.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import cn.yh.dao.IAdminDAO;
import cn.yh.dao.util.AbstractDAOImpl;
import cn.yh.vo.Admin;
import cn.yh.vo.Emp;

public class AdminDaoImlp extends AbstractDAOImpl implements IAdminDAO{
	private PreparedStatement ps;
	public AdminDaoImlp(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doCreate(Admin vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Admin vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findSplit(Integer currentpage, Integer linesize, String column, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findLogin(Admin vo) throws Exception {
		String sql = "select count(id) from admin where id=? and password=?";
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
