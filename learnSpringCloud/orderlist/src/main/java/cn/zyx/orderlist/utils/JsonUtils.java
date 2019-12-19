package cn.zyx.orderlist.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * description: JsonUtils <br>
 * date: 2019/12/19 15:47 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JsonNode string2Object(String str){
        try {
            return OBJECT_MAPPER.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
