package cn.zyx.framework.ioc;

/**
 * description: 将Property标签属性封装成对象 <br>
 * date: 2020/6/9 15:04 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
