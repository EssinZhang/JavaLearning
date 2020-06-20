package cn.demo.thread.po;

import org.springframework.stereotype.Component;

/**
 * @Description 线程安全问题测试PO
 * @ClassName ResultPo
 * @Author ZhangYixin
 * @date 2020.06.15 09:30
 */
@Component
public class ResultPo {

    private String status;

    private  int id;

    private  int count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
