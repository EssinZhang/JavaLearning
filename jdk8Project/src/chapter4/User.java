package chapter4;

/**
 * description: User <br>
 * date: 2020/10/10 15:57 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class User {

    private int userId;

    private String userName;

    private String passWd;

    public User(int userId, String userName, String passWd) {
        this.userId = userId;
        this.userName = userName;
        this.passWd = passWd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
}
