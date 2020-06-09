package cn.zyx.framework.sqlSource;

/**
 * @Description
 * @ClassName ParameterMapping
 * @Author ZhangYixin
 * @date 2020.06.04 20:30
 */
public class ParameterMapping {

    private String name;

    private Class  type;

    public ParameterMapping(String name, Class type) {
        this.name = name;
        this.type = type;
    }

    public ParameterMapping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}
