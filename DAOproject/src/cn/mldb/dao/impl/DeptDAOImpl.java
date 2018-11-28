package cn.mldb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldb.dao.IDeptDAO;
import cn.mldn.vo.Dept;

public class DeptDAOImpl implements IDeptDAO {
	private Connection conn;
	private PreparedStatement ps;
	public DeptDAOImpl(Connection conn){
		this.conn = conn;
	}

	public boolean doCreate(Dept vo) throws Exception {
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, vo.getDeptno());
		this.ps.setString(2, vo.getDname());
		this.ps.setString(3, vo.getLoc());
		return this.ps.executeUpdate()>0;
	}

	public boolean doUpdate(Dept vo) throws Exception {
		String sql = "update dept set dname=?,loc=? where deptno=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, vo.getDname());
		this.ps.setString(2, vo.getLoc());
		this.ps.setInt(3, vo.getDeptno());
		return this.ps.executeUpdate()>0;
	}

	public boolean doRemove(Set<Integer> ids) throws Exception {
		if(ids==null||ids.size()==0){
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from dept where deptno  in(");
		Iterator<Integer> ite = ids.iterator();
		while(ite.hasNext()){
			sql.append(ite.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.ps = conn.prepareStatement(sql.toString());
		return this.ps.executeUpdate()==ids.size();
	}

	public Dept findById(Integer id) throws Exception {
		Dept vo = null;
		String sql = "select deptno,dname,loc from dept where deptno=?";
		this.ps = this.conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
		}
		return vo;
	}

	public List<Dept> findAll() throws Exception {
		List<Dept> alllist = new ArrayList<Dept>();
		String sql = "select deptno,dname,loc from dept";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()){
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			alllist.add(vo);
		}
		return alllist;
	}

	public List<Dept> findSplit(Integer currentpage, Integer linesize,
			String colum, String keyword) throws Exception {
		throw new Exception("此方法未实现");
	}

	public Integer getAllCount(String colum, String keyword) throws Exception {
		throw new Exception("此方法未实现");
	}

}
