package cn.yh.dao;

import cn.yh.vo.Member;

public interface IMemberDAO {
	public Member findById(String id) throws Exception;
	public boolean doCreate(Member vo) throws Exception;
}
