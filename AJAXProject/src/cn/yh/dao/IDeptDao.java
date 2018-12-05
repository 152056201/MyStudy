package cn.yh.dao;

import java.util.List;
import java.util.Set;

import cn.yh.vo.Dept;

public interface IDeptDao {
	public boolean doCreate(Dept vo) throws Exception;
	public boolean doUpdate(Dept vo) throws Exception;
	public boolean doRemove(Set<Integer> ids) throws Exception;
	public Dept findById(Integer id) throws Exception;
	public List<Dept> findAll()throws Exception;
}
