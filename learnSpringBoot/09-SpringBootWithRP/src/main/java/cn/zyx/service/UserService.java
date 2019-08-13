package cn.zyx.service;

import cn.zyx.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> dataMap = new HashMap<>();

    static {
        dataMap.put("1",new User("24","kobe"));
        dataMap.put("2",new User("6","james"));
        dataMap.put("3",new User("18","golden"));
    }

    /**
     * 返回用户列表
     * @return
     */
    public Flux<User> list(){
        Collection<User> list = UserService.dataMap.values();

        return Flux.fromIterable(list);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Mono<User> getById(final String id){
        return Mono.justOrEmpty(UserService.dataMap.get(id));
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public Mono<User> delById(final String id){
        return Mono.justOrEmpty(UserService.dataMap.remove(id));
    }
}
