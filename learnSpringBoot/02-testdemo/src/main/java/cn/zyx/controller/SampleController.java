package cn.zyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SampleController {

    private Map<String,Object> params = new HashMap<>();

    @RequestMapping("/test/home")
    public  String home(){
        return "SampleTestClass";
    }


    @GetMapping("/api/v1/testFilter")
    public Object testFilter(){

        System.out.println("username Test");
        params.put("username","zyx");
        return params;
    }

    @GetMapping("/v1/listenerTest")
    public Object testListener(HttpServletRequest request){
        params.clear();
        String name = request.getParameter("name");
        params.put("name",name);
        return params;
    }

    @GetMapping("/api2/v1/testIntecepter")
    public Object testIntecepter(){

        System.out.println("Intecepter Test");
        params.put("username","zyx");
        return params;
    }
}
