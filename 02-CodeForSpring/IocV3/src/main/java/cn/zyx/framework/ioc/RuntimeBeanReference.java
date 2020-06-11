package cn.zyx.framework.ioc;

/**
 * description: property子标签中的ref值 <br>
 * date: 2020/6/9 15:16 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class RuntimeBeanReference {

    //ref属性值
    private String ref;

    public RuntimeBeanReference(String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
