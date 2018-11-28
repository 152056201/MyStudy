package cn.mldb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldb.factory.DAOFactory;
import cn.mldb.service.IEmpService;
import cn.mldn.dlc.DateBaseConnection;
import cn.mldn.vo.Emp;

public class EmpServiceImpl implements IEmpService {
	//���������ڲ�����һ�����ݿ��������ʵ��������
	private DateBaseConnection dbc = new DateBaseConnection();
	public boolean insert(Emp vo) throws Exception {
		try{
			//Ҫ���ӵĹ�Ա�����������ڣ���findById����null��null��ʾ���Խ����¹�Ա���ݵı���
			if(DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findById(vo.getEmpno())==null){
				return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public boolean update(Emp vo) throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doUpdate(vo);
				
			
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

	public boolean delete(Set<Integer> ids) throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doRemove(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public Emp get(Integer ids) throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findById(ids);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public List<Emp> list() throws Exception {
		try{
			return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

	public Map<String, Object> list(int currentpage, int linesize,
			String colum, String keyword) throws Exception {
		try{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("allEmps", DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findSplit(currentpage, linesize, colum, keyword));
			map.put("EmpCount", DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).getAllCount(colum, keyword));
			return map;
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
	}

}
