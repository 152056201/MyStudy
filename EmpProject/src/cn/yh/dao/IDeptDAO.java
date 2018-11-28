package cn.yh.dao;

import java.util.List;

import cn.yh.vo.Dept;

public interface IDeptDAO extends IDAO<Integer, Dept> {
	/**
	 * 部门完整信息查询
	 * @return
	 * @throws Exception
	 */
	public List<Dept> findAllByStat()throws Exception;
	public Dept findByIdDetials(Integer id) throws Exception;
}
