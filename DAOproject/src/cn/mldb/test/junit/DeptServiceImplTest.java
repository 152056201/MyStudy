package cn.mldb.test.junit;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import cn.mldb.factory.ServetFactory;
import cn.mldn.vo.Dept;

public class DeptServiceImplTest {

	@Test
	public void testInsert() {
		Dept vo = new Dept();
		vo.setDeptno(11);
		vo.setDname("EDITOR");
		vo.setLoc("TIANJIN");
		try {
			TestCase.assertTrue(ServetFactory.getIDeptServiceInstacne().insert(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			TestCase.assertTrue(ServetFactory.getIDeptServiceInstacne().update(vo));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(11);
		
		try {
			TestCase.assertTrue(ServetFactory.getIDeptServiceInstacne().delete(ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServetFactory.getIDeptServiceInstacne().get(10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServetFactory.getIDeptServiceInstacne().list().size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testListIntIntStringString() {
		fail("Not yet implemented");
	}

}
