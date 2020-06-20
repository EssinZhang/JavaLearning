package cn.demo.thread.polymer;

import cn.demo.thread.po.ResultPo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName ThreadTestPolymer
 * @Author ZhangYixin
 * @date 2020.06.15 09:53
 */
@Component
public class ThreadTestPolymer {

    public static final long seriaVersionUid = -12312374738L;

    private static final Logger log4j = Logger.getLogger(ThreadTestPolymer.class);

    public ResultPo ThreadTest(ResultPo resultPo){


        System.out.println("Polymer: "+resultPo);

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Polymer2:"+resultPo);

        return resultPo;
    }

}
