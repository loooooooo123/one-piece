package baseUtils;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import net.sf.json.JSONArray;

/*
 * json转换类
 * 
*/

public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 对象转字符串
	 * @throws IOException 
	 *
	 */
	public static String objectToJson(Object data) throws IOException {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json转对象
	 * 
	 * 
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json转list
	 * 
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {

		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*
	 *  list转json：
        JSONArray jsonData = JSONArray.fromObject(list1);
	 * 
	 * */
}
