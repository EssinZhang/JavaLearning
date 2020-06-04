package cn.zyx.framework.sqlSource;

/**
 * description: SqlSource <br>
 * date: 2020/6/4 13:20 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface SqlSource {

    /**
     * 解析封装好的SqlNode信息
     * @param param
     * @return
     */
    BoundSql getBoundSql(Object param);
}
