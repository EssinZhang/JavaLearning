package chapter4;

/**
 * description: UserDto <br>
 * date: 2020/10/10 15:59 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class UserDto {

    private int UserId;

    private String userName;

    public UserDto(int userId, String userName) {
        UserId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "UserId=" + UserId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
