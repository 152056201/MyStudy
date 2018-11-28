package cn.yh.vo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@SuppressWarnings("unused")
public class Dept {
	private Integer deptno;
	private String dname;
	private String loc;
	private List<Emp> emps;
	private Map<String,Object> stat; //表示存储所有统计信息
	public Dept(){
		
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Dept(Integer deptno, String dname, String loc) {
		
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public void setStat(Map<String, Object> stat) {
		this.stat = stat;
	}
	public Map<String, Object> getStat() {
		return stat;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
