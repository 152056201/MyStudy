package cn.mldb.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldb.factory.ServetFactory;
import cn.mldn.vo.Emp;

public class TestEmpSplit {
	public static void main(String[] args) {
		try {
			Map<String, Object> map = ServetFactory.getIEempServceInstance().list(1, 5, "ename", "");
			int count = (Integer) map.get("EmpCount");
			System.out.println("Êý¾ÝÁ¿£º"+ count);
			@SuppressWarnings("unchecked")
			List<Emp> all = (List<Emp>) map.get("allEmps");
			Iterator<Emp> ita = all.iterator();
			while(ita.hasNext()){
				Emp vo = ita.next();
				System.out.println(vo.getEname()+" "+vo.getJob());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
