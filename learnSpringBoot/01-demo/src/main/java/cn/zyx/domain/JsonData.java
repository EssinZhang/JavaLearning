package cn.zyx.domain;

import java.io.Serializable;

public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    //状态码 0表示成功 -1 表示失败
    private int code;

    //结果
    private Object data;

    //错误描述
    private String msg;

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
