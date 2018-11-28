package cn.vo.utils;

import javax.servlet.http.HttpServletRequest;

public class basePath {
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+
				":"+request.getServerPort()+path+"/";
		return basePath;
	}
}
