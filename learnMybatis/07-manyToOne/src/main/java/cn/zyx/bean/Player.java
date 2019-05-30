package cn.zyx.bean;

/**
 * 球员
 */
public class Player {
    private int id;
    private String name;
    private Team team;


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team.id=" + team.getId() +
                ", team.name=" + team.getName() +
                '}';
    }

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
