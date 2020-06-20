package cn.demo.thread;

import cn.demo.thread.po.ResultPo;
import cn.demo.thread.polymer.ThreadTestPolymer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @ClassName TestThread2
 * @Author ZhangYixin
 * @date 2020.06.16 09:09
 */
public class TestThread2 implements Runnable {

    public static final long seriaVersionUid = -12312374741L;

    private static final Logger log4j = Logger.getLogger(TestThread.class);

    private void testThread2Start(ResultPo resultPo){

    }

    @Override
    public void run() {
        try{
            ThreadTestPolymer polymer = new ThreadTestPolymer();
            //polymer.ThreadTest(resultPo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
