package cn.zyx.test;

import cn.zyx.bean.Player;
import cn.zyx.bean.Team;
import cn.zyx.dao.PlayerDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTest {
    private SqlSession sqlSession;
    private PlayerDao playerDao;

    @Before
    public void init(){
        sqlSession = MybatisUtil.getSqlSession();
        playerDao = sqlSession.getMapper(PlayerDao.class);
    }

    @After
    public void closeSqlSession(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void selectTeamById(){
        Player player = playerDao.selectPlayerById(1);
        System.out.println(player);
    }

    @Test
    public void selectPlayer(){
        List<Player> playerList  = playerDao.selectPlayer();
        playerList.forEach((player -> {
            System.out.println(player);
        }));
    }

}
