package cn.mldb.dao;

import java.util.List;
import java.util.Set;


/**
 * 定义公共接口
 * @author Mr.Y
 *
 * @param <K>表示要操作的主键类型，由子接口实现
 * @param <V>表示要操作的VO接口，由子接口实现
 */
public interface IDAO<K,V> {
	/**
	 * 实现数据增加操作
	 * @param vo 包含了数据增加的VO对象
	 * @return 保存成功返回true, 失败保存false
	 * @throws Exception SQL执行异常
	 */
	public boolean doCreate(V vo) throws Exception;
	/**
	 * 实现数据修改操作，本次修改根据ID进行全部字段数据修改
	 * @param vo 要修改数据的信息，一个提供有ID信息
	 * @return 修改成功返回true, 失败保存false
	 * @throws Exception SQL执行异常
	 */
	public boolean doUpdate(V vo) throws Exception;
	/**
	 * 执行数据的批量删除操作，要删除的数据以Set集合的的形式保存
	 * @param ids 包含所有要删除数据的ID，不包含重复数据
	 * @return 删除成功返回true（删除的数据个数与要删除的数据个数相同）, 失败保存false
	 * @throws Exception SQL执行异常
	 */
	public boolean doRemove(Set<K> ids) throws Exception;
	/**
	 * 根据雇员id去查询雇员信息
	 * @param id 要查询的雇员编号
	 * @return 如果雇员信息存在则以VO的形式返回雇员信息，如果不存在 返回null
	 * @throws Exception SQL执行异常
	 */
	public V findById(K id) throws Exception;
	/**
	 * 查询指定数据表的全部内容，并以集合形式返回
	 * @return 如果表中有数据，则所有数据会封装为VO对象以list集合形式返回，如果没有数据list集合数据为0（size()==0）不是null
	 * @throws Exception SQL执行异常
	 */
	public List<V> findAll() throws Exception;
	/**
	 * 分页进行数据模糊查询，查询结果以集合形式返回
	 * @param currentpage 当前所在的页
	 * @param linesize 每页所在的行数
	 * @param colum 模糊查询的数据列
	 * @param keyword 模糊查询的关键字
	 * @return 如果表中有数据，则所有数据会封装为VO对象以list集合形式返回，如果没有数据list集合数据为0（size()==0）不是null
	 * @throws Exception SQL执行异常
	 */
	public List<V> findSplit(Integer currentpage,Integer linesize,String colum,String keyword) throws Exception;
	/**
	 * 进行模糊查询数据量的统计，表中没有记录返回0
	 * @param colum 模糊查询的数据列
	 * @param keyword 模糊查询的关键字
	 * @return 返回表中的数据量，如果没有返回0
	 * @throws Exception SQL执行异常
	 */
	public Integer getAllCount(String colum,String keyword) throws Exception;
}
