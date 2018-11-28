package cn.mldb.test;

import java.util.Date;

import cn.mldb.factory.ServetFactory;
import cn.mldn.vo.Emp;

public class TestEmpUpadate {
	public static void main(String[] args) {
		Emp vo = new Emp();
		
		vo.setEname("MEISS");
		vo.setJob("FOOTBALL");
		vo.setMgr(7839);
		vo.setHiredate(new Date());
		vo.setSal(12000.0);
		vo.setComm(500.0);
		vo.setDeptno(20);
		vo.setEmpno(9999);
		try {
			System.out.println(ServetFactory.getIEempServceInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
