package cn.yh.factory;


import cn.yh.service.ICityService;
import cn.yh.service.IDeptService;
import cn.yh.service.IMemberService;
import cn.yh.service.IProviecneService;
import cn.yh.service.impl.ICityServiceImpl;
import cn.yh.service.impl.IDeptServiceImpl;
import cn.yh.service.impl.IMServiceImpl;
import cn.yh.service.impl.IProvienceServiceImpl;

public class ServiceFactory {
	public static IMemberService getIMembrServiceInstance() {
		return new IMServiceImpl();
	}
	public static IProviecneService getIProvienceServieInstance() {
		return new IProvienceServiceImpl();
	}
	public static ICityService getICityServiceInstance() {
		return new ICityServiceImpl();
	}
	public static IDeptService getIDeptServiceInstance() {
		return new IDeptServiceImpl();
	}
}
