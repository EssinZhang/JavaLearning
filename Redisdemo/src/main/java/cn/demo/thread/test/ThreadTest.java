package cn.demo.thread.test;

import cn.demo.thread.TestThread;
import cn.demo.thread.TestThread2;
import cn.demo.thread.po.ResultPo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName ThreadTest
 * @Author ZhangYixin
 * @date 2020.06.15 09:59
 */
@Component
@Scope("singleton")
public class ThreadTest {

    private static final Logger log4j = Logger.getLogger(ThreadTest.class);


    public static void main(String[] args) {
        //test2();
    }

    @Test
    public static void test(){
        for (int i = 0; i < 10; i++) {

            TestThread testThread = new TestThread();

            ResultPo resultPo = new ResultPo();
            resultPo.setId(i);
            resultPo.setCount(i+1);
            resultPo.setStatus("A");
            testThread.setResultPo(resultPo);
            //new TestThread();
            //thread.setResultPo(resultPo);
            new Thread(testThread).start();
        }
    }
    @Test
    public void test2(){
        for (int i = 0; i < 1000; i++) {

            TestThread2 testThread2 = new TestThread2();

            ResultPo resultPo = new ResultPo();
            resultPo.setId(i);
            resultPo.setCount(i+1);
            resultPo.setStatus("A");
            //testThread2.setResultPo(resultPo);
            //new TestThread();
            //thread.setResultPo(resultPo);
            new Thread(testThread2).start();
        }
    }
}
