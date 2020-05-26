package com.qdu.mall.util;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName: com.qdu.mall.util.JsonUtil.java
 * @Description: 操作json的封装方法
 * @author: ZhangJunqing
 * @date:  2020-04-25 16:38
 * @version V1.0
 */
public class JsonUtil {

    /**
     * @Description: json转换成对象
     * @author: ZhangJunqing
     * @date:  2020-04-25 16:38
     * @param: 传入对象，json字符串
     * @return: Object
     */
    public static Object jsonToObj(Class objClass, String jsonStr) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }

    /**
     * @Description: 对象转换成json
     * @author: ZhangJunqing
     * @date:  2020-04-25 16:41
     * @param: 传入对象
     * @return: json字符串
     */
    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}