package cn.yh.dao.factory;

import java.sql.Connection;

import cn.yh.dao.IAdminDAO;
import cn.yh.dao.IDeptDAO;
import cn.yh.dao.IEmpDAO;
import cn.yh.dao.Impl.AdminDaoImlp;
import cn.yh.dao.Impl.DeptDAOImpl;
import cn.yh.dao.Impl.EmpDaoImpl;

public class DAOFactory {
	public static IDeptDAO getIDeptDaoInstance(Connection conn){
			return new DeptDAOImpl(conn);
	}
	public static IEmpDAO getIEmpDaoInstance(Connection conn){
		return new EmpDaoImpl(conn);
	}
	public static IAdminDAO getIAdimDaoInstance(Connection conn) {
		return new AdminDaoImlp(conn);
	}
	
}


