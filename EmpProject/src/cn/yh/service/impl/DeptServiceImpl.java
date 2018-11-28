package cn.yh.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.yh.dao.factory.DAOFactory;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.service.IDeptService;
import cn.yh.vo.Dept;

public class DeptServiceImpl implements IDeptService {
	DateBaseConnection dbc = new DateBaseConnection();

	@Override
	public boolean insert(Dept vo) throws Exception {
		try{
			if(DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findById(vo.getDeptno())== null){
				return DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).doCreate(vo);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	@Override
	public boolean update(Dept vo) throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	@Override
	public Map<String,Object> delete(Set<Integer> ids) throws Exception {
		try{
			Map<String,Object> map = new HashMap<>();
			//查询所有照片
			Set<String> photoes = DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAllPhotoByDeptno(ids);
			//取消事务自动提交
			this.dbc.getConn().setAutoCommit(false);
			boolean flag = false;//表示最终是否成功标记
			Iterator<Integer> ite = ids.iterator();//找到每一个雇员编号
			while(ite.hasNext()){
				//根据部门编号删除所有雇员
				DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doRemoveByDeptno(ite.next()) ;
			}
			//删除所有部门信息
			flag = DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).doRemove(ids);
			map.put("flag", flag);
			if(flag == true) {
				map.put("allPhotos", photoes);
			}
			this.dbc.getConn().commit();
			return map;
		}catch(Exception e){
			this.dbc.getConn().rollback();
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Dept> list() throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Dept updatePre(Integer id) throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Dept> listDetails() throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findAllByStat();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Dept show(Integer id,Integer currentpage, Integer linesize, 
			String column, String keyword) throws Exception {
		try{
			Dept dept = DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findByIdDetials(id);
			if(dept!=null) {// 如果有部门，返回所有雇员信息
				dept.setEmps(DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAllByDeptno(id, currentpage, linesize, column, keyword));
			}
			return dept;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	

	

}
