package util;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * codehaus.jackson 工具类
 * Created by luxiaobo on 2017/4/11.
 */
public class JsonUtil {
    private static final ObjectMapper OM = new ObjectMapper();

    /**
     * 将json字符串转换为Java对象
     *
     * @param jsonString
     * @param clazz
     * @return T
     * @throws IOException
     */
    public static <T> T toJavaObject(String jsonString, Class<T> clazz) throws IOException {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        return OM.readValue(jsonString, clazz);
    }

    /**
     * 将Java对象转换为字符串
     *
     * @param object
     * @return json string
     * @throws IOException
     */
    public static String toJSONString(Object object) throws IOException {
        if (null == object) {
            return null;
        }
        return OM.writeValueAsString(object);

    }
}
