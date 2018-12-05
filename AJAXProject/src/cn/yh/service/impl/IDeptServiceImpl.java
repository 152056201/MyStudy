package cn.yh.service.impl;

import java.util.List;
import java.util.Set;

import cn.yh.dbc.DatabaseConnection;
import cn.yh.factory.DAOFactory;
import cn.yh.service.IDeptService;
import cn.yh.vo.Dept;

public class IDeptServiceImpl implements IDeptService{
	DatabaseConnection dbc = new DatabaseConnection();
	@Override
	public boolean insert(Dept vo) throws Exception {
		try {
			if(DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).findById(vo.getDeptno())==null) {
				return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).doCreate(vo);
			}
			return false;
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Dept vo) throws Exception {
		try {
			return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).doUpdate(vo);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).doRemove(ids);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public Dept findById(Integer id) throws Exception {
		try {
			return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).findById(id);
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public List<Dept> list() throws Exception {
		try {
			return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).findAll();
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	@Override
	public boolean checkDeptno(Integer id) throws Exception {
		try {
			return DAOFactory.getIdeptDaoInstance(this.dbc.getConn()).
						findById(id)==null;
			
		}catch(Exception e) {
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
