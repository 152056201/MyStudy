package cn.yh.Json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 生成数组
 * @author Mr.Y
 *
 */
public class CreateDateDemoB {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name","袁浩");
		obj.put("age", 22);
		JSONArray array = new JSONArray();
		array.add("篮球");
		array.add("足球");
		array.add("电影");
		obj.put("skill", array);
		System.out.println(obj);
	}
}
