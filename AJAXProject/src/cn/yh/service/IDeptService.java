package cn.yh.service;

import java.util.List;
import java.util.Set;

import cn.yh.vo.Dept;

public interface IDeptService {
	/**
	 * 先使用findById()检查id是否可用 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Dept vo)throws Exception;
	public boolean update(Dept vo) throws Exception;
	public boolean delete(Set<Integer> ids) throws Exception;
	public Dept findById(Integer id) throws Exception;
	public List<Dept> list() throws Exception;
	/**
	 * 此方法用于ajax检查部门编号是否存在，如果存在则不可使用
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean checkDeptno(Integer id) throws Exception;
}
