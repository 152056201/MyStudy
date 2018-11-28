package cn.yh.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.yh.dao.factory.DAOFactory;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.service.IEmpService;
import cn.yh.vo.Emp;

public class EmpServiceImpl implements IEmpService {
	DateBaseConnection dbc = new DateBaseConnection();
	@Override
	public boolean insert(Emp vo) throws Exception {
		try{
			if(DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findById(vo.getEmpno())==null){
				return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doCreate(vo);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	@Override
	public boolean update(Emp vo) throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doRemove(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Emp> list() throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}


	@Override
	public Map<String, Object> list(int currentpage, int linesize,
			String column, String keyword) throws Exception {
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("allEmps", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findSplit(currentpage, linesize,column, keyword));
			map.put("empCount", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).getAllCount(column, keyword));
			return map;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	@Override
	public Emp show(Integer id) throws Exception {
		try {
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findByIdDetials(id);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public Map<String, Object> insertPer() throws Exception {
		try{
			Map<String,Object> map = new HashMap<>();
			map.put("allEmps", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAll());
			map.put("allDepts", DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findAll());
			return map;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> updatePre(Integer id) throws Exception {
		try{
			Map<String ,Object> map = new HashMap<>();
			map.put("allEmps", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAll());
			map.put("emp", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findByIdDetials(id));
			map.put("allDepts", DAOFactory.getIDeptDaoInstance(this.dbc.getConn()).findAll());
			return map;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> listDetails(Integer currentpage, Integer linesize, String column, String keyword)
			throws Exception {
		try {
			Map<String,Object> map = new HashMap<>();
			map.put("allEmps", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAllSplitByDetails(currentpage, linesize, column, keyword));
			map.put("empCount", DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).getAllCount(column, keyword));
			return map;
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

}
