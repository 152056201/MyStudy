package cn.yh.util;

public class TestMD5 {

	public static void main(String[] args) {
		MD5 md = new MD5();
		System.out.println(md.GetMD5Code("yh123"));
		System.out.println(md.GetMD5Code("admin"));
	}
}
