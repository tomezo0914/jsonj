package jsonj;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class convert List or Map to JSON. 
 * 
 * @author takeshi.toyotome
 *
 */
public class JSONObject {
	
	/** latest version. */
	public static final String VSRSION = "0.9.1";
	
	private static String DQ = "\"";
	private static String COMMA = ",";
	private static String COLON = ":";
	private static String NULL = "null";

	/**
	 * Convert List object to String of JSON pattern.
	 * 
	 * @param list
	 * @return string of json
	 */
	public static String toJSON(List<?> list) {
		if (list == null) {
			return NULL;
		}
		if (list.size() <= 0) {
			return NULL;
		}
		StringBuilder json = new StringBuilder();
		json.append("[");
		for (int i = 0, size = list.size(); i < size; i++) {
			json.append(toJsonString(list.get(i)));
			json.append(COMMA);
		}
		return json.substring(0, json.length() - 1) + "]";
	}

	/**
	 * Convert Map object to String of JSON pattern.
	 * 
	 * @param map
	 * @return string of json
	 */
	public static String toJSON(Map<String, ?> map) {
		if (map == null) {
			return NULL;
		}
		Set<String> keySet = map.keySet();
		if (keySet.isEmpty()) {
			return NULL;
		}
		StringBuilder json = new StringBuilder();
		json.append("{");
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			json.append(DQ).append(key).append(DQ).append(COLON);
			Object val = map.get(key);
			json.append(toJsonString(val));
			json.append(COMMA);
		}
		return json.substring(0, json.length() - 1) + "}";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String toJsonString(Object val) {
		StringBuilder json = new StringBuilder();
		if (val == null) {
			json.append(NULL);
		} else if (val instanceof String) {
			json.append(DQ).append(val).append(DQ);
		} else if (val instanceof Number) {
			json.append(val);
		} else if (val instanceof Boolean) {
			json.append(val);
		} else if (val instanceof Map) {
			json.append(toJSON((Map) val));
		} else if (val instanceof List) {
			json.append(toJSON((List) val));
		} else {
			json.append(NULL);
		}
		return json.toString();
	}
	
	public static void main(String[] args) {
		getVersion();
	}

	/**
	 * Return the latest version.
	 * 
	 * @return latest version
	 */
	public static String getVersion() {
		System.out.println("jsonj version " + VSRSION);
		return VSRSION;
	}

}
