package cn.yh.factory;

import java.sql.Connection;

import cn.yh.DaoImpl.CityDaoImpl;
import cn.yh.DaoImpl.DeptDaoImpl;
import cn.yh.DaoImpl.IMemberImpl;
import cn.yh.DaoImpl.ProvicneDaoImpl;
import cn.yh.dao.ICityDAO;
import cn.yh.dao.IDeptDao;
import cn.yh.dao.IMemberDAO;
import cn.yh.dao.IProviencesDAO;

public class DAOFactory {
	public static IMemberDAO getIMemberDaoInstance(Connection conn) {
		return new IMemberImpl(conn);
	}
	public static IProviencesDAO getIProviencesDaoInstance(Connection conn) {
		return new ProvicneDaoImpl(conn);
	}
	public static ICityDAO getICityDaoInstance(Connection conn) {
		return new CityDaoImpl(conn);
	}
	public static IDeptDao getIdeptDaoInstance(Connection conn) {
		return new DeptDaoImpl(conn);
	}
}

