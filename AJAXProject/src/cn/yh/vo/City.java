package cn.yh.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class City implements Serializable {
	private Integer cid;
	private String city;
	private Integer pid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
