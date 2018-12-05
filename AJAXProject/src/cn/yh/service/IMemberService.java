package cn.yh.service;

import cn.yh.vo.Member;

public interface IMemberService {
	public boolean checkMid(String mid) throws Exception ;
	public boolean insert(Member vo) throws Exception;
}
