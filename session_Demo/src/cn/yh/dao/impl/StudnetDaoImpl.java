package cn.yh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yh.dao.StudentDao;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.vo.Student;

public class StudnetDaoImpl implements StudentDao{
	private Connection conn;
	private PreparedStatement pstmt;
	public StudnetDaoImpl(Connection conn){
		this.conn = conn;
	}
	
	public List<Student> show() throws Exception {
		List<Student> list = new ArrayList<>();
		String sql = " select num,name,gander,birth,phone,address from student ";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while(rs.next()) {
			Student s = new Student();
			s.setNum(rs.getString(1));
			s.setName(rs.getString(2));
			s.setGander(rs.getString(3));
			s.setBirth(rs.getDate(4));
			s.setPhone(rs.getString(5));
			s.setAddress(rs.getString(6));
			list.add(s);
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		StudnetDaoImpl sdi = new StudnetDaoImpl(new DateBaseConnection().getConn());
		List<Student> list = sdi.show();
		for (Student student : list) {
			System.out.println(student.getNum()+"-"+student.getName()+"-"+student.getGander());
		}
	}

}
