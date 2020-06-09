package cn.zyx.mybatisV3.sqlSession;

import java.util.List;

/**
 * @Description
 * @ClassName SqlSession
 * @Author ZhangYixin
 * @date 2020.06.07 16:25
 */
public interface SqlSession {

    /**
     * 查询集合信息
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    <T> List<T> selectList(String statementId,Object param);

    /**
     * 查询单个信息
     * @param statementId
     * @param param
     * @param <T>
     * @return
     */
    <T> T selectOne(String statementId,Object param);
}
