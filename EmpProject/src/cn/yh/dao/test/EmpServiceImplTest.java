package cn.yh.dao.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import cn.yh.dao.factory.ServiceFactory;
import cn.yh.vo.Dept;

public class EmpServiceImplTest {

	@Test
	public void testInsert() {
		Dept vo = new Dept();
		vo.setDeptno(12);
		vo.setDname("EDITOR");
		vo.setLoc("TIANJIN");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptService().insert(vo));
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}

	@Test
	public void testUpdate() {
		Dept vo = new Dept();
		vo.setDeptno(11);
		vo.setDname("EDITOR");
		vo.setLoc("BEIJING");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptService().update(vo));
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1111);
		
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpService().delete(ids));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIDeptService().list());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptService().list().size()>0);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testListIntIntStringString() {
		fail("Not yet implemented");
	}

}
