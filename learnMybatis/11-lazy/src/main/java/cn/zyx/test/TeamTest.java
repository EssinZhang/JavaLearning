package cn.zyx.test;

import cn.zyx.bean.Team;
import cn.zyx.dao.TeamDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeamTest {
    private SqlSession sqlSession;
    private TeamDao teamDao;

    @Before
    public void init(){
        sqlSession = MybatisUtil.getSqlSession();
        teamDao = sqlSession.getMapper(TeamDao.class);
    }

    @After
    public void closeSqlSession(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void selectTeamById(){
        Team team = teamDao.selectTeamById(2);
        System.out.println(team.getName());
    }

}
