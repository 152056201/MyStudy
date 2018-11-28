package cn.yh.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Student implements Serializable {
	private String num;
	private String name;
	private String gander;
	private Date birth;
	private String phone;
	private String address;
	public Student(String num, String name, String gander, Date birth, String phone, String address) {
		super();
		this.num = num;
		this.name = name;
		this.gander = gander;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
	}
	public Student() {
		super();
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGander() {
		return gander;
	}
	public void setGander(String gander) {
		this.gander = gander;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
