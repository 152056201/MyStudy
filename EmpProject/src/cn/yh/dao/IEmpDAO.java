package cn.yh.dao;

import java.util.List;
import java.util.Set;

import cn.yh.vo.Emp;

public interface IEmpDAO extends IDAO<Integer, Emp> {
	//定义一个方法根据雇员编号删除雇员信息
	public void doRemoveByDeptno(Integer deptno) throws Exception;
	
	/**
	 * 表示要查询一个雇员的完整信息
	 * @param id
	 * @return 要查询的内容以vo对象返回	，否则返回null
	 * @throws Exception
	 */
	public Emp findByIdDetials(Integer id) throws Exception;
	
	/**
	 * 详细的雇员信息，包含有雇员完整信息，领导信息，部门信息
	 * @param currentpage
	 * @param linesize
	 * @param column
	 * @param keyword
	 * @return 以List集合方式返回，如果没有返回集合长度为0
	 * @throws Exception
	 */
	public  List<Emp> findAllSplitByDetails(Integer currentpage, Integer linesize,
			String column, String keyword) throws Exception;
	
	public  List<Emp> findAllByDeptno(Integer deptno,Integer currentpage, Integer linesize,
			String column, String keyword) throws Exception;
	/**
	 * 获得指定部门雇员所有照片
	 * @param deptno
	 * @return
	 * @throws Exception
	 */
	public Set<String> findAllPhotoByDeptno(Set<Integer> deptno) throws Exception;
}
