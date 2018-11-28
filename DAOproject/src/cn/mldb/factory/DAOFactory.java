package cn.mldb.factory;

import java.sql.Connection;


import cn.mldb.dao.IDeptDAO;
import cn.mldb.dao.IEmpDAO;
import cn.mldb.dao.impl.DeptDAOImpl;
import cn.mldb.dao.impl.EmpDAOImpl;


public class DAOFactory {
	public static IEmpDAO getIEmpDaoInstance(Connection conn){
		return new EmpDAOImpl(conn);
	}
	public static IDeptDAO getIDeptDaoInstance(Connection conn){
		return new DeptDAOImpl(conn);
		
	}

}
