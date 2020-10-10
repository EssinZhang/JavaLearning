package chapter4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: StreamofMapDemo01 <br>
 * date: 2020/10/10 15:54 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamofMapDemo01 {

    public static void main(String[] args) {
        List<User> userList = Arrays.asList(new User(1,"kobe","la824"),
                                        new User(2,"wade","mia3"),
                                        new User(3,"james","la23"),
                                        new User(4,"tracy","magic1"));
        List<UserDto> collect = userList.stream().map(obj -> {
            UserDto userDto = new UserDto(obj.getUserId(), obj.getUserName());
            return userDto;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

}
