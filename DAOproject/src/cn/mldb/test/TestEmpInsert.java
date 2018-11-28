package cn.mldb.test;



import java.util.Date;

import cn.mldb.factory.ServetFactory;
import cn.mldn.vo.Emp;

public class TestEmpInsert {
	public static void main(String[] args) {
		Emp vo = new Emp();
		vo.setEname("´óÂíºï");
		vo.setJob("Ö÷²¥");
		vo.setMgr(7369);
		vo.setHiredate(new Date());
		vo.setSal(1230.0);
		vo.setComm(200.0);
		vo.setDeptno(20);
		vo.setEmpno(9999);
		try {
			System.out.println(ServetFactory.getIEempServceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
