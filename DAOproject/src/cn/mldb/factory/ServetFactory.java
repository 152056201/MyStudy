package cn.mldb.factory;

import cn.mldb.service.IDeptService;
import cn.mldb.service.IEmpService;
import cn.mldb.service.impl.DeptServiceImpl;
import cn.mldb.service.impl.EmpServiceImpl;

public class ServetFactory {
	public static IEmpService getIEempServceInstance(){
		return new EmpServiceImpl();
		
	}
	public static IDeptService getIDeptServiceInstacne(){
		return new DeptServiceImpl();
	}

}
