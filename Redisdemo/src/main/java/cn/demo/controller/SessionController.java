package cn.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis/session")
public class SessionController {

    @GetMapping("setSession")
    public Map<String,Object> setSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.getSession().setAttribute("requestURL",request.getRequestURL());
        map.put("requestURL",request.getRequestURL());
        return map;
    }

    @GetMapping("getSession")
    public Object getSession(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionIdUrl",request.getSession().getAttribute("requestURL"));
        map.put("sessionId",request.getSession().getId());
        return map;

    }
}
