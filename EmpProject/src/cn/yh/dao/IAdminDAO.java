package cn.yh.dao;

import cn.yh.vo.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	/**
	 * 实现登录验证操作，如果正确的用户名密码返回true佛否则返回false
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean findLogin(Admin vo)throws Exception;

}
