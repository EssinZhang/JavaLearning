package cn.zyx.controller;

import cn.zyx.domain.User;
import cn.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1")
public class UserController {

//    @Autowired
//    private UserService userService;

    private final UserService userService;

    public UserController(final UserService service){
        this.userService = service;
    }

    @GetMapping("user")
    public Mono<String> userTest(){
        return Mono.just("ReactiveProgram");
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @GetMapping("find")
    public Mono<User> findById(final String id){
        return userService.getById(id);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Mono<User> delById(final String id){
        return userService.delById(id);
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping("findAll")
    public Flux<User> getList(){
        return userService.list();
    }

    /**
     * 功能描述：列表
     * @return
     */
    @GetMapping(value="list",produces= MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> list(){
        return userService.list().delayElements(Duration.ofSeconds(2));
    }
}
