package cn.zyx.returnValue;

import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法返回Object类型数据
 */
@Controller
public class ReturnObjectController {

    @RequestMapping(name = "/returnObject01.do",produces = "text/html;charset=utf-8")
    @ResponseBody//将返回值添加到响应体
    public Object returnObject01()throws Exception{

        return "科比·returnString";
    }

    @RequestMapping("/returnObject02.do")
    @ResponseBody
    public Object returnmap()throws Exception{
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("hello","你好");
        stringMap.put("world","世界");

        return stringMap;
    }
}
