package cn.yh.Json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ��������
 * @author Mr.Y
 *
 */
public class CreateDateDemoB {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name","Ԭ��");
		obj.put("age", 22);
		JSONArray array = new JSONArray();
		array.add("����");
		array.add("����");
		array.add("��Ӱ");
		obj.put("skill", array);
		System.out.println(obj);
	}
}
