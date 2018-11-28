package cn.yh.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.yh.vo.Dept;



public interface IDeptService {
	public boolean insert(Dept vo) throws Exception;
	public boolean update(Dept vo) throws Exception;
	/**
	 * 批量删除部门数据
	 * <li>根据要删除的部门编号，找到对应雇员的图片，调用IEmpDAO.findAllPhotoByDeptno()方法
	 * <li>删除此部门所有雇员数据，调用IEmpDAO.doRemoveByDeptno()
	 * <li>根据部门删除数据 调用IDeptDAO.doRemove()
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> delete(Set<Integer> ids) throws Exception;
	public List<Dept> list() throws Exception;
	public Dept updatePre(Integer id) throws Exception;
	/**
	 * 列出所有部门详细信息，调用IDeptDAO中的findAllByStat()
	 * @return
	 * @throws Exception
	 */
	public List<Dept> listDetails() throws Exception;
	/**
	 * 调用IDeptDAO中的findByIdDetials()
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept show(Integer id,Integer currentpage, Integer linesize, 
			String column, String keyword) throws Exception;
	
}
