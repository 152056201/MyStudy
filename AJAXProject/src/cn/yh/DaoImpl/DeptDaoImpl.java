package cn.yh.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.yh.dao.IDeptDao;
import cn.yh.vo.Dept;

public class DeptDaoImpl implements IDeptDao{
	private Connection conn;
	private PreparedStatement ps;
	public DeptDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Dept vo) throws Exception {
		String sql = " insert into dept(deptno,dname,loc) values(?,?,?) ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, vo.getDeptno());
		this.ps.setString(2, vo.getDname());
		this.ps.setString(3, vo.getLoc());
		
		return this.ps.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Dept vo) throws Exception {
		String sql = " update dept set dname=?,loc=? where deptno=? ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, vo.getDname());
		this.ps.setString(2, vo.getLoc());
		this.ps.setInt(3, vo.getDeptno());
		return this.ps.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		if(ids==null||ids.size()==0) {
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from dept where deptno in( " );
		Iterator<Integer> ite = ids.iterator();
		while(ite.hasNext()) {
			sql.append(ite.next()).append(",");
		}
		sql.delete(sql.length()-1,sql.length()).append(")");
		this.ps = this.conn.prepareStatement(sql.toString());
		return this.ps.executeUpdate()==ids.size();
	}

	@Override
	public Dept findById(Integer id) throws Exception {
		Dept dept = null;
		String sql = " select deptno,dname,loc from dept where deptno=? ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			dept = new Dept();
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
		}
		return dept;
	}

	@Override
	public List<Dept> findAll() throws Exception {
		List<Dept> list = new ArrayList<>();
		Dept dept = new Dept();
		String sql = " select deptno,dname,loc from dept ";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			list.add(dept);
		}
		return list;
	}
	
}
