package cn.yh.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.yh.dao.IMemberDAO;
import cn.yh.vo.Member;

public class IMemberImpl implements IMemberDAO{
	private Connection conn;
	private PreparedStatement ps;
	public IMemberImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public Member findById(String id) throws Exception {
		Member vo = null;
		String sql = " select mid,password from member where mid=? ";
		this.ps= this.conn.prepareStatement(sql);
		this.ps.setString(1, id);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
		}
		
		return vo;
	}

	@Override
	public boolean doCreate(Member vo) throws Exception {
		String sql = " insert into member(mid,password) values(?,?) ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, vo.getMid());
		this.ps.setString(2, vo.getPassword());
		return this.ps.executeUpdate()>0;
	}
	

}
