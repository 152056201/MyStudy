package cn.yh.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import cn.yh.dao.IEmpDAO;
import cn.yh.dao.util.AbstractDAOImpl;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.vo.Dept;
import cn.yh.vo.Emp;

public class EmpDaoImpl extends AbstractDAOImpl implements IEmpDAO {
	private PreparedStatement ps;
	public EmpDaoImpl(Connection conn){
		super(conn);
	}
	
	@Override
	public boolean doCreate(Emp vo) throws Exception {
		String sql = " insert into emp(empno,ename,job,hiredate,sal,comm,mgr,deptno,photo,note) values(?,?,?,?,?,?,?,?,?,?) ";
		this.ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getEmpno());
		ps.setString(2, vo.getEname());
		ps.setString(3, vo.getJob());
		ps.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
		ps.setDouble(5, vo.getSal());
		ps.setDouble(6, vo.getComm());
		if(vo.getMgr()==null) {
			this.ps.setNull(7, Types.NULL);
		}else {
			this.ps.setInt(7, vo.getMgr().getEmpno());
		}
		if(vo.getDept()==null) {
			this.ps.setNull(8, Types.NULL);
		}else {
			this.ps.setInt(8, vo.getDept().getDeptno());
		}
		ps.setString(9, vo.getPhoto());
		ps.setString(10, vo.getNote());
		return this.ps.executeUpdate()>0;
	}

	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		String sql = " update emp set ename=?,job=?,hiredate=?,sal=?,comm=?,mgr=?,deptno=?,photo=?,note=? where empno=? ";
		this.ps = super.conn.prepareStatement(sql);
		ps.setString(1, vo.getEname());
		ps.setString(2, vo.getJob());
		ps.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
		ps.setDouble(4, vo.getSal());
		ps.setDouble(5, vo.getComm());
		if(vo.getMgr()==null) {
			this.ps.setNull(6, Types.NULL);
		}else {
			
			this.ps.setInt(6, vo.getMgr().getEmpno());
		}
		if(vo.getDept()==null) {
			this.ps.setNull(7, Types.NULL);
		}else {
			this.ps.setInt(7, vo.getDept().getDeptno());
		}
		ps.setString(8, vo.getPhoto());
		ps.setString(9, vo.getNote());
		ps.setInt(10, vo.getEmpno());
		
		return this.ps.executeUpdate()>0;
	}
	
	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		
		return super.doRemoveHandle(ids," emp "," empno ");
	}

	/*@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		if(ids==null||ids.size()==0){
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("delete from myemp where empno in(");
		Iterator<Integer> ite = ids.iterator();
		while(ite.hasNext()){
			sql.append(ite.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		this.ps = conn.prepareStatement(sql.toString());
		return this.ps.executeUpdate()==ids.size();
	}
*/
	@Override
	public Emp findById(Integer id) throws Exception {
		Emp vo = null;
		String sql = " select empno,ename,job,hiredate,sal,comm from emp where empno=? ";
		this.ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			vo= new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			
			vo.setComm(rs.getDouble(6));
		}
		return vo;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		String sql = " select empno,ename,job,hiredate,sal,comm,photo,note from emp ";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			vo.setPhoto(rs.getString(7));
			vo.setNote(rs.getString(8));
			list.add(vo);
			
		}
		return list;
	}
	@Override
	public List<Emp> findSplit(Integer currentpage, Integer linesize,
			String column, String keyword) throws Exception {
		List<Emp> list = new ArrayList<Emp>();
		String sql = " select * from " +
				" (select empno,ename,job,hiredate,sal,comm,photo,note,ROWNUM rn " +
				" from emp where " + column +
				" like ? and ROWNUM<=?) temp " +
				" where temp.rn>? ";
		this.ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		ps.setInt(2, currentpage*linesize);
		ps.setInt(3, (currentpage-1)*linesize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			vo.setPhoto(rs.getString(7));
			vo.setNote(rs.getString(8));
			list.add(vo);
		}
		return list;
	}
	@Override
	public Integer getAllCount(String column, String keyword) throws Exception {
		return super.AllCountHandle(" emp ", column, keyword);
	}
	@Override
	public void doRemoveByDeptno(Integer deptno) throws Exception {
		String sql = " delete from emp where deptno=? ";
		this.ps = super.conn.prepareStatement(sql);
		ps.setInt(1, deptno);
		this.ps.executeUpdate();
		
	}
	@Override
	public Emp findByIdDetials(Integer id) throws Exception {
		Emp vo = null;
		String sql = " select e.empno,e.ename,e.job,e.hiredate,e.sal,e.comm, "
				+ " m.empno mno,m.ename mname,d.deptno,d.dname,e.photo,e.note "
				+ " from emp e,emp m,dept d "
				+ " where e.empno=? "
				+ " and e.mgr = m.empno(+) and e.deptno = d.deptno(+) ";
		this.ps = super.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo= new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			Emp mgr = new Emp();
			mgr.setEmpno(rs.getInt(7));
			mgr.setEname(rs.getString(8));
			vo.setMgr(mgr);
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt(9));
			dept.setDname(rs.getString(10));
			vo.setDept(dept);
			vo.setPhoto(rs.getString(11));
			vo.setNote(rs.getString(12));
		}
		return vo;
	}
	@Override
	public List<Emp> findAllSplitByDetails(Integer currentpage, Integer linesize, 
			String column, String keyword) throws Exception {
		List<Emp> list = new ArrayList<>();
		String sql = " select * from( "
				+ " select e.empno,e.ename,e.job,e.hiredate,e.sal,e.comm, "
				+ " m.empno mno,m.ename mname,d.deptno dno,d.dname dna,e.photo,e.note,ROWNUM rn "
				+ " from emp e,emp m,dept d "
				+ " where e." + column
				+ " like ? and ROWNUM<=? and e.mgr = m.empno(+) and e.deptno = d.deptno(+)) temp "
				+ " where temp.rn>? ";
		this.ps = super.conn.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		ps.setInt(2, currentpage+linesize);
		ps.setInt(3, (currentpage-1)*linesize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			Emp mgr = new Emp();
			mgr.setEmpno(rs.getInt(7));
			mgr.setEname(rs.getString(8));
			vo.setMgr(mgr);
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt(9));
			dept.setDname(rs.getString(10));
			vo.setDept(dept);
			list.add(vo);
			vo.setPhoto(rs.getString(11));
			vo.setNote(rs.getString(12));
		}
		return list;
	} 
	

	@Override
	public List<Emp> findAllByDeptno(Integer deptno,Integer currentpage, Integer linesize, String column, String keyword)
			throws Exception {
		List<Emp> all = new ArrayList<>();
		String sql = " select * from( "
				+ " select e.empno,e.ename,e.job,e.hiredate,e.sal,e.comm, "
				+ " m.empno mno,m.ename mname,d.deptno dno,d.dname dna,ROWNUM rn "
				+ " from emp e,emp m,dept d "
				+ " where e." + column
				+ " like ? and e.deptno=? and ROWNUM<=? and e.mgr = m.empno(+) and e.deptno = d.deptno(+)) temp "
				+ " where temp.rn>? ";
		this.ps = super.conn.prepareStatement(sql);
		ps.setString(1,"%"+keyword+"%");
		ps.setInt(2, deptno);
		ps.setInt(3, currentpage*linesize);
		ps.setInt(4, (currentpage-1)*linesize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			Emp mgr = new Emp();
			mgr.setEmpno(rs.getInt(7));
			mgr.setEname(rs.getString(8));
			vo.setMgr(mgr);
			Dept dept = new Dept();
			dept.setDeptno(rs.getInt(9));
			dept.setDname(rs.getString(10));
			vo.setDept(dept);
			all.add(vo);
		} 
		return all;
	}
	
	@Override
	public Set<String> findAllPhotoByDeptno(Set<Integer> deptno) throws Exception {
		Set<String> allPhotos = new HashSet<String>();
		if(deptno.size()==0) {
			return allPhotos; //表示没有照片
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" select photo from emp where deptno in( " );
		Iterator<Integer> ite = deptno.iterator();
		while(ite.hasNext()) {
			sql.append(ite.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(" ) ");
		this.ps = this.conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			allPhotos.add(rs.getString(1));
		}
		return allPhotos;
	}
	public static void main(String[] args) throws Exception {
		EmpDaoImpl edi = new EmpDaoImpl(new DateBaseConnection().getConn());
		List<Emp> list = edi.findAllSplitByDetails(1, 10, "ename", "");
		for (Emp emp : list) {
			System.out.println(emp.getEmpno()+"-"+emp.getEname()+"-"+emp.getMgr().getEmpno()+"-"+emp.getMgr().getEname());
		}
	}
	
}
	
 


