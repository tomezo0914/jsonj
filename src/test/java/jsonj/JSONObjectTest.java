package jsonj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;


public class JSONObjectTest {

	@BeforeClass
	public static void beforeClass() {
		JSONObject.getVersion();
	}
	
	@Test
	public void toJSONfromList() {
		List<Object> list = new ArrayList<Object>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		String strlist = JSONObject.toJSON(list);
		System.out.println(strlist);
	}

	@Test
	public void toJSONfromMap() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("aa", "111");
		param.put("bb", 222);
		param.put("cc", true);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a1", "aaaa111");
		map.put("b1", "bbbb111");
		param.put("dd", map);
				
		String str = JSONObject.toJSON(param);
		System.out.println(str);
	}

}
