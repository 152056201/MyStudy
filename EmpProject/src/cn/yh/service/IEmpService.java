package cn.yh.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.yh.vo.Emp;


public interface IEmpService {
	public boolean insert(Emp vo) throws Exception;
	public boolean update(Emp vo) throws Exception;
	public boolean delete(Set<Integer> ids) throws Exception;
	public List<Emp> list() throws Exception;
	
	public Map<String,Object> list(int currentpage,int linesize,String colnum,String keyword) throws Exception;
	
	/**
	 * 根据雇员编号查看雇员信息
	 * @param id 雇员编号
	 * @return 查询到以vo对象形式返回
	 * @throws Exception
	 */
	public Emp show(Integer id) throws Exception;
	/**
	 * 表示进行雇员增加前的准备操作，因为要增加前要查询出所有雇员和所有部门的数据
	 * @return 返回两组信息，一个是雇员信息，一个是部门信息  <br>
	 * <li>	key = allEmps, value = IEmpDao.findAll() 查询所有雇员
	 * @throws Exception
	 */
	public Map<String,Object> insertPer() throws Exception;
	/**
	 * 表示进行雇员增加前的准备操作，因为要增加前要查询出所有雇员和所有部门的数据
	 * @return 返回三组信息，一个是雇员信息，一个是部门信息  <br>
	 * <li>	key = allEmps, value = IEmpDAO.findAll() 查询所有雇员<br>
	 * <li> key = emp,value= IEmpDAO.findByIdDetails() 查询雇员完整信息
	 * @throws Exception
	 */
	public Map<String,Object> updatePre(Integer id) throws Exception;
	/**
	 * 使用详细列表列出雇员的完整信息<br>
	 * <li>调用IEmpDAO.findAllSplitDetails()详细列出雇员信息
	 * <li>调用 IEmpDAO.getAllCount()列出雇员详细人数
	 * @param currentpage
	 * @param linesize
	 * @param column
	 * @param keyword
	 * @return 以MAP集合返回<br>
	 * <li> key = allEmps,value = IEmpDAO.findAllSplitDetails() 分页显示
	 * <li> key = empCount ,value = IEmpDAO.getAllCount()取得全部记录数
	 * @throws Exception
	 */
	public Map<String,Object> listDetails(Integer currentpage, Integer linesize, 
			String column, String keyword) throws Exception;

}
