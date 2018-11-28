package cn.mldb.test.junit;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import cn.mldb.factory.ServetFactory;
import cn.mldn.vo.Emp;

public class EmpServiceImplTest {
	private static int empno;
	static{
		new Random().nextInt(10000);//动态生成一个empno数据
	}
	@Test
	public void testInsert() {
		Emp vo = new Emp();
		vo.setEmpno(empno);
		vo.setEname("冠佑");
		vo.setJob("鼓手");
		vo.setMgr(7369);
		vo.setHiredate(new Date());
		vo.setSal(1230.0);
		vo.setComm(200.0);
		vo.setDeptno(20);
		try {
			TestCase.assertTrue(ServetFactory.getIEempServceInstance().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Emp vo = new Emp();
		vo.setEname("大旭");
		vo.setJob("ANALYST");
		vo.setMgr(7369);
		vo.setHiredate(new Date());
		vo.setSal(1500.0);
		vo.setComm(200.0);
		vo.setDeptno(20);
		vo.setEmpno(9999);
		try {
			TestCase.assertTrue(ServetFactory.getIEempServceInstance().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(9999);
		
			TestCase.assertTrue(ServetFactory.getIEempServceInstance().delete(ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServetFactory.getIEempServceInstance().get(9999));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServetFactory.getIEempServceInstance().list().size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListIntIntStringString() {
		
		try {
			Map<String,Object> map = ServetFactory.getIEempServceInstance().list(1, 5, "ename", "");
			int count = (Integer) map.get("EmpCount");
			System.out.println("数据量："+count);
			@SuppressWarnings("unchecked")
			List<Emp> all = (List<Emp>) map.get("allEmps");
			TestCase.assertTrue(count>0||all.size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
