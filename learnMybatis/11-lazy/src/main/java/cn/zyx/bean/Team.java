package cn.zyx.bean;

import java.util.List;

/**
 * 球队
 */
public class Team {
    private int id;
    private String name;
    private List<Player> playerList;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerList=" + playerList +
                '}';
    }

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Player> playerList) {
        this.name = name;
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
