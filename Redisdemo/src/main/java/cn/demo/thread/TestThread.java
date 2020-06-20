package cn.demo.thread;

import cn.demo.thread.po.ResultPo;
import cn.demo.thread.polymer.ThreadTestPolymer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName TestThread
 * @Author ZhangYixin
 * @date 2020.06.15 09:26
 */
@Component
@Scope("singleton")
public class TestThread implements Runnable {

    public static final long seriaVersionUid = -12312374739L;

    private static final Logger log4j = Logger.getLogger(TestThread.class);

    private ThreadLocal<ResultPo> threadLocal = new ThreadLocal<>();

    @Autowired
    private ThreadTestPolymer threadTestPolymer;

    private ResultPo resultPo;

    private ResultPo getThreadResultPo(){
        threadLocal.set(this.getResultPo());
        return this.getResultPo();
    }

    public ResultPo getResultPo() {
        return resultPo;
    }

    public void setResultPo(ResultPo resultPo) {
        this.resultPo = resultPo;
    }



    @Override
    public void run() {
        try{
            //ThreadTestPolymer threadTestPolymer = new ThreadTestPolymer();
            getThreadResultPo();
            //threadTestPolymer.ThreadTest(threadLocal.get());
            threadTestPolymer.ThreadTest(resultPo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadLocal.remove();
        }
    }
}
