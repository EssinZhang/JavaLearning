package cn.zyx.dao;

import cn.zyx.bean.Player;

import java.util.List;

public interface PlayerDao {
    Player selectPlayerById(int id);
    List<Player> selectPlayer();
}
