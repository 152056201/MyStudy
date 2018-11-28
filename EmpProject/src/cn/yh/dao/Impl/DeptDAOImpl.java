package cn.yh.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import cn.yh.dao.IDeptDAO;
import cn.yh.dao.util.AbstractDAOImpl;
import cn.yh.dao.util.MathUtil;

/*import cn.yh.dbc.DateBaseConnection;*/
import cn.yh.vo.Dept;
import cn.yh.vo.Emp;

public class DeptDAOImpl extends AbstractDAOImpl implements IDeptDAO {
	private PreparedStatement ps;
	public DeptDAOImpl(Connection conn){
			super(conn);
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

//	public boolean doRemove(Set<Integer> ids) throws Exception {
//		if(ids==null||ids.size()==0){
//			return false;
//		}
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete from dept where deptno  in(");
//		Iterator<Integer> ite = ids.iterator();
//		while(ite.hasNext()){
//			sql.append(ite.next()).append(",");
//		}
//		sql.delete(sql.length()-1, sql.length()).append(")");
//		this.ps = conn.prepareStatement(sql.toString());
//		return this.ps.executeUpdate()==ids.size();
//	}

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
			vo.setDeptno(rs.getInt("deptno"));
			vo.setDname(rs.getString("dname"));
			vo.setLoc(rs.getString("loc"));
			//System.out.println(rs.getString(2)+"-"+rs.getString(3));
			alllist.add(vo);
		}
		return alllist;
	}
	

	
	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		
		return super.doRemoveHandle(ids,"dept","deptno");
	}

	@Override
	public List<Emp> findSplit(Integer currentpage, Integer linesize,
			String colum, String keyword) throws Exception {
		
		return null;
	}

	@Override
	public Integer getAllCount(String colum, String keyword) throws Exception {
		
		return null;
	}

	@Override
	public List<Dept> findAllByStat() throws Exception {
		List<Dept> list = new ArrayList<Dept>();
		String sql = " select d.deptno,d.dname,d.loc,temp.count,temp.sum,temp.avg,temp.max,temp.min "
				+ " from dept d, "
				+ " ( select deptno dno,count(empno) count,sum(sal) sum,avg(sal) avg,max(sal) max,min(sal) min "
				+ " from emp group by deptno ) temp "
				+ " where d.deptno=temp.dno(+) ";
		this.ps = super.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Dept vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.setStat(new HashMap<String,Object>());
			vo.getStat().put("count", rs.getInt(4));
			vo.getStat().put("sum", rs.getDouble(5));
			vo.getStat().put("avg", MathUtil.round(rs.getDouble(6), 2));
			vo.getStat().put("max", rs.getDouble(7));
			vo.getStat().put("min", rs.getDouble(8));
			list.add(vo);
		}
		return list;
	}

	@Override
	public Dept findByIdDetials(Integer id) throws Exception {
		Dept vo = null;
		String sql = " select d.deptno,d.dname,d.loc,temp.count,temp.sum,temp.avg,temp.max,temp.min "
				+ " from dept d, "
				+ " ( select deptno dno,count(empno) count,sum(sal) sum,avg(sal) avg,max(sal) max,min(sal) min "
				+ " from emp "
				+ " group by deptno ) temp "
				+ " where d.deptno=temp.dno(+) and d.deptno=? ";
		this.ps = super.conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			vo = new Dept();
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.setStat(new HashMap<String,Object>());
			vo.getStat().put("count", rs.getInt(4));
			vo.getStat().put("sum", rs.getDouble(5));
			vo.getStat().put("avg", MathUtil.round(rs.getDouble(6), 2));
			vo.getStat().put("max", rs.getDouble(7));
			vo.getStat().put("min", rs.getDouble(8));
			
		}
		return vo;
		
	}

	
	/*public static void main(String[] args) throws Exception {
		DeptDAOImpl dao = new DeptDAOImpl(new DateBaseConnection().getConn());
		List<Dept> list = dao.findAll();
		//Dept d = dao.findByIdDetials(10);
		for (Dept dept : list) {
			System.out.println(dept.getDeptno()+"-"+dept.getDname()+"-"+dept.getLoc());
		}
		//System.out.println(d.getDeptno()+"-"+d.getDname()+"-"+d.getLoc());
	}*/


}
