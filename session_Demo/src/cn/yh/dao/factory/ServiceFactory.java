package cn.yh.dao.factory;


import cn.yh.service.impl.AdminServletImpl;
import cn.yh.service.impl.StudentServiceImpl;

public class ServiceFactory {
	public static StudentServiceImpl getIStudentService(){
		return new StudentServiceImpl();
	}
	public static AdminServletImpl getIAdminService() {
		return new AdminServletImpl();
	}
}
