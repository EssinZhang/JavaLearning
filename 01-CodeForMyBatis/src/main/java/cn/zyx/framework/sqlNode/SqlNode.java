package cn.zyx.framework.sqlNode;

/**
 * @Description 提供对封装的sql脚本信息进行处理操作
 * @ClassName SqlNode
 * @Author ZhangYixin
 * @date 2020.06.04 20:41
 */
public interface SqlNode {

    void apply(DynamicContext context);

}
