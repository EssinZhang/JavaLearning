package cn.zyx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
public class SSEController {

    @RequestMapping(value = "/get_data",produces = "text/event-stream;charset=UTF-8")
    public String push(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "data:测试 行情：" + Math.random() +"\n\n";
    }
}
