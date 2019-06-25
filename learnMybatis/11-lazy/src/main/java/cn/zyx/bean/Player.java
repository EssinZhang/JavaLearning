package cn.zyx.bean;

/**
 * 球员
 */
public class Player {
    private int id;
    private String name;
    private int tid;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }

    public Player() {
    }

    public Player(String name, int tid) {
        this.name = name;
        this.tid = tid;
    }

    public Player(int id, String name, int tid) {
        this.id = id;
        this.name = name;
        this.tid = tid;
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
