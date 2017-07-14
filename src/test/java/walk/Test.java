package walk;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

	public void test(){
		Set<String> set = new HashSet<String>(){{
			add("{'create_time': '2017-07-13 14:17:19', 'id': 13L, 'title': '\\xe5\\xb7\\x9d\\xe5\\x89\\xa7\\xe6\\x81\\x8b'}");
			add("{'create_time': '2017-07-13 14:20:10', 'id': 14L, 'title': '\\xe4\\xba\\xac\\xe5\\x9f\\x8e\\xe9\\x97\\xb2\\xe5\\xa6\\x87'}");
		}};
		JSONArray json = JSONObject.parseArray(set.toString());
		String s = json.getString(0);
		JSONObject object = JSONObject.parseObject(s);
		try {
			System.out.println(new String(object.getString("title").getBytes(),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Test t = new Test();
		t.test();
	}
}
