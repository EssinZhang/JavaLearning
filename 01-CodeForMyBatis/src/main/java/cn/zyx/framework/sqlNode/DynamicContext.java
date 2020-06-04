package cn.zyx.framework.sqlNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description sqlNode处理过程中的上下文对象   sql语句和传参
 * @ClassName DynamicContext
 * @Author ZhangYixin
 * @date 2020.06.04 20:49
 */
public class DynamicContext {
    /**
     * 为了将所有SqlNode处理之后的信息，拼接成一条完整的sql语句
     */
    private StringBuffer stringBuffer = new StringBuffer();

    /**
     * 为了提供SqlNode执行过程中需要的一些信息
     */
    private Map<String,Object> bindings = new HashMap<>();

    public DynamicContext(Object param) {
        this.bindings.put("_parameter",param);
    }

    public String getSql(){
        return stringBuffer.toString();
    }

    public void appendSql(String sqlText){
        this.stringBuffer.append(sqlText);
        this.stringBuffer.append(" ");
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void setStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

    public void addBinding(String name , Object binding) {
        this.bindings.put(name,binding);
    }
}
