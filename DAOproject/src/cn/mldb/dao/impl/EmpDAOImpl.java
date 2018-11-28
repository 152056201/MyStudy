package cn.mldb.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldb.dao.IEmpDAO;
import cn.mldn.dlc.DateBaseConnection;
import cn.mldn.vo.Emp;

public class EmpDAOImpl implements IEmpDAO {
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;
	/**
	 * 如果想使用数据层进行原子性的功能实现操作，必须需要提供有Connection接口对象
	 * 由于开发中业务层需要调用数据层，所以数据库的打开与关闭交由业务层处理
	 */
	public EmpDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	public boolean doCreate(Emp vo) throws Exception {
		
		String sql = " insert into myemp(empno,ename,job,mgr,hiredate,sal,comm,deptno)" +
				" values(?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getEmpno());
		this.pstmt.setString(2, vo.getEname());
		this.pstmt.setString(3, vo.getJob());
		if(vo.getMgr()==null){
			this.pstmt.setString(4, null);
		}else{
			this.pstmt.setInt(4, vo.getMgr());
		}
		
		this.pstmt.setDate(5, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(6 ,vo.getSal());
		this.pstmt.setDouble(7, vo.getComm());
		if(vo.getDeptno()==null){
			this.pstmt.setString(8, null);
		}else{
			this.pstmt.setInt(8, vo.getDeptno());
		}

		return this.pstmt.executeUpdate()>0;
	}

	public boolean doUpdate(Emp vo) throws Exception {
		String sql = " UPDATE myemp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		
		this.pstmt.setString(1, vo.getEname());
		this.pstmt.setString(2, vo.getJob());
		this.pstmt.setInt(3, vo.getMgr());
		this.pstmt.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(5 ,vo.getSal());
		this.pstmt.setDouble(6, vo.getComm());
		this.pstmt.setInt(7, vo.getDeptno());
		this.pstmt.setInt(8, vo.getEmpno());
		return this.pstmt.executeUpdate()>0;
	}

	public boolean doRemove(Set<Integer> ids) throws Exception {
		if(ids==null || ids.size()==0){
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from myemp where empno in(  ");
		Iterator<Integer> iter = ids.iterator();
		while(iter.hasNext()){
			sql.append(iter.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.pstmt = this.conn.prepareStatement(sql.toString());//把StringBuffer变为String
		return this.pstmt.executeUpdate() == ids.size();
	}

	public Emp findById(Integer id) throws Exception {
		Emp vo = null;
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from myemp where empno = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMgr(rs.getInt(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getDouble(6));
			vo.setComm(rs.getDouble(7));
			vo.setDeptno(rs.getInt(8));
		}
		return vo;
	}

	public List<Emp> findAll() throws Exception {
		List<Emp> alllist = new ArrayList<Emp>();
		String sql = "select empno,ename,job,hiredate,sal,comm from emp";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			alllist.add(vo);
		}
		return alllist;
	}

	public List<Emp> findSplit(Integer currentpage, Integer linesize,
			String colum, String keyword) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		String sql = " select * from" +
				     " (select empno,ename,job,mgr,hiredate,sal,comm,deptno,ROWNUM rn" +
				     " from myemp"+
				     " where " + colum + " like ? and ROWNUM<=?) temp "+
				     " where temp.rn>?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyword+"%");
		this.pstmt.setInt(2, currentpage*linesize);
		this.pstmt.setInt(3, (currentpage-1)*linesize); 
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setMgr(rs.getInt(4));
			vo.setHiredate(rs.getDate(5));
			vo.setSal(rs.getDouble(6));
			vo.setComm(rs.getDouble(7));
			vo.setDeptno(rs.getInt(8));
			list.add(vo);
		}		     
		return list;
	}

	public Integer getAllCount(String colum, String keyword) throws Exception {
		String sql = "select count(empno) from myemp where " + colum + " like ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyword+"%");
		ResultSet rs = this.pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		EmpDAOImpl edi = new EmpDAOImpl(new DateBaseConnection().getConnection());
		List<Emp> emp = edi.findAll();
		for (Emp emp2 : emp) {
			System.out.println(emp2.getEmpno()+"-"+emp2.getEname()+"-"+emp2.getJob()+"-"+emp2.getHiredate()+"-"+emp2.getSal()+"-"+emp2.getComm());
		}
	}

}
