package cn.zyx.ioc;

/**
 * description: 封装property子标签中的value属性值 <br>
 * date: 2020/6/9 15:25 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class TypedPropertyStringValue {

    // value属性值
    private String value;

    // value属性值对应的真正类型（Bean中属性的类型）
    private Class<?> targetType;

    public TypedPropertyStringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class<?> getTargetType() {
        return targetType;
    }

    public void setTargetType(Class<?> targetType) {
        this.targetType = targetType;
    }
}
