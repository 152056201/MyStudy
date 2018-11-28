package cn.yh.service.impl;

import java.util.List;
import cn.yh.dao.factory.DaoFactory;
import cn.yh.dbc.DateBaseConnection;
import cn.yh.service.StudntService;
import cn.yh.vo.Student;

public class StudentServiceImpl implements StudntService {
	DateBaseConnection dbc = new DateBaseConnection();
	@Override
	public List<Student> list() throws Exception {
		try{
			return DaoFactory.getStudentInstance(this.dbc.getConn()).show();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}

}
