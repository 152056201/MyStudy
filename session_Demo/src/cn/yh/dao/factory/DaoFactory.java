package cn.yh.dao.factory;

import java.sql.Connection;

import cn.yh.dao.IAdminDAO;
import cn.yh.dao.StudentDao;
import cn.yh.dao.impl.AdminDaoImpl;
import cn.yh.dao.impl.StudnetDaoImpl;

public class DaoFactory {
	public static StudentDao getStudentInstance(Connection conn) {
		return new StudnetDaoImpl(conn);
	}
	public static IAdminDAO getAdminInstance(Connection conn) {
		return new AdminDaoImpl(conn);
	}

}
