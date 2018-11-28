package cn.mldb.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface IService<K,V> {
	/**
	 * 实现雇员数据增加操作，本次操作要调用IEmpDAO接口<br>
	 * <li>需要调用IEmpDAO.findById()方法，判断增加ID的数据是否存在
	 * <li>如果要增加的数据编号不存在则调用IEmpDAO.doCreate()方法，返回操作结果
	 * @param vo 包含了要增加数据的VO对象
	 * @return 如果增加数据ID存在或保存失败则返回false ，反之返回true
	 * @throws Exception
	 */
	public boolean insert(V vo)throws Exception;
	/**
	 * 实现雇员数据修改操作，调用IEmpDAO.doUpdate()方法，本次修改属于全部内容的修改
	 * @param vo 包含修改数据的VOV对象
	 * @return
	 * @throws Exception
	 */
	public boolean update(V vo)throws Exception;
	
	/**
	 * 雇员删除，可以删除多个雇员信息，调用了IEmpDAO.doRemove()方法
	 * @param ids 包含了删除全部数据的集合，没有重复数据
	 * @return 
	 * @throws Exception
	 */
	public boolean delete(Set<K> ids)throws Exception;
	/**
	 * 根据雇员编号查找雇员完整信息，调用IEempDAO.findById()
	 * @param ids 要查询的雇员编号
	 * @return 如果雇员信息存在则以VO的形式返回雇员信息，如果不存在 返回null	
	 * @throws Exception
	 */
	public V get(Integer ids)throws Exception;
	/**
	 * 查询全部雇员信息，调用IEmpDAO.findAll()
	 * @return 查询结果以list返回 如果没有数据则集合长度为0
	 * @throws Exception
	 */
	public List<V> list() throws Exception;
	/**
	 * 实现数据模糊查询与数据统计，调用IEmpDAO两个方法<br>
	 * <li>第一个调用IEmpDAO.findAllSplit()方法，查询表所有数据，返回List<Emp>;
	 * <li>第二个调用IEmpDAO.getAllCount()方法，查询所有数据量，返回Integer；
	 * @param currentpage 
	 * @param linesize
	 * @param colum
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> list(int currentpage,int linesize,String colum,String keyword) throws Exception;

}
