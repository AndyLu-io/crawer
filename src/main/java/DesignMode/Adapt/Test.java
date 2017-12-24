package DesignMode.Adapt;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : qingxiao
 * @Description:
 * @Date : Created in 14:41  2017/11/9
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("platfotm", "IOS");
        paramMap.put("name", "Tom");
        paramMap.put("id", "123");
        paramMap.put("customerno", "1246dgsjdhj");
        paramMap.put("phone", "15757174039");
        paramMap.put("password", "asdf1234");
        Object json = JSONObject.toJSON(paramMap);
        System.out.println(json);
    }
}
