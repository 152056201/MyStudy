	package cn.mldb.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldb.factory.DAOFactory;
import cn.mldb.service.IDeptService;
import cn.mldn.dlc.DateBaseConnection;
import cn.mldn.vo.Dept;

public class DeptServiceImpl implements IDeptService {
	private DateBaseConnection dbc = new DateBaseConnection();
	public boolean insert(Dept vo) throws Exception {
		try{
			if(DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).findById(vo.getDeptno())==null){
				return DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
	public boolean update(Dept vo) throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).doUpdate(vo);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public boolean delete(Set<Integer> ids) throws Exception {
		try{
			
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).doRemove(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public Dept get(Integer ids) throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).findById(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public List<Dept> list() throws Exception {
		try{
			return DAOFactory.getIDeptDaoInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public Map<String, Object> list(int currentpage, int linesize,
			String colum, String keyword) throws Exception {
		try{
			throw new Exception("此方法未实现");
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
