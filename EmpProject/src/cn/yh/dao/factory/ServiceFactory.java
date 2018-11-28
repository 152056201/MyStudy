package cn.yh.dao.factory;

import cn.yh.service.IAdminService;
import cn.yh.service.IDeptService;
import cn.yh.service.IEmpService;
import cn.yh.service.impl.AdminServiceImlp;
import cn.yh.service.impl.DeptServiceImpl;
import cn.yh.service.impl.EmpServiceImpl;

public class ServiceFactory {
	public static IDeptService getIDeptService(){
		return new DeptServiceImpl();
	}
	public static IEmpService getIEmpService(){
		return new EmpServiceImpl();
	}
	public static IAdminService getIAdminService() {
		return new AdminServiceImlp();
		
	}

}
