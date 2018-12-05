package cn.yh.service;

import java.util.List;
import java.util.Set;

import cn.yh.vo.Dept;

public interface IDeptService {
	/**
	 * ��ʹ��findById()���id�Ƿ���� 
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
	 * �˷�������ajax��鲿�ű���Ƿ���ڣ���������򲻿�ʹ��
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean checkDeptno(Integer id) throws Exception;
}
