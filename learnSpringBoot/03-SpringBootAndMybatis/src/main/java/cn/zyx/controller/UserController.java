package cn.zyx.controller;



import cn.zyx.domain.JsonData;
import cn.zyx.domain.User;
import cn.zyx.mapper.UserMapper;
import cn.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *@作者 小D课堂  小D
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	/**
	 * 功能描述: user 保存接口
	 * @return
	 */
	@GetMapping("/add")
	public Object add(){
		
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("xdclass");
		user.setPhone("10010000");
		int id = userService.add(user);
		
       return JsonData.buildSuccess(id);
	}


	@GetMapping("test1")
	public Object test1(){
		return "test1";

	}

	/**
	 * 查找全部用户
	 * @return
	 */
	@GetMapping("findAll")
	public Object findAll(){

       return JsonData.buildSuccess(userMapper.getAll());
	}

	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@GetMapping("find_by_id")
	public Object findById(long id){
       return JsonData.buildSuccess(userMapper.findById(id));
	}


	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@GetMapping("del_by_id")
	public Object delById(long id){
	userMapper.delete(id);
       return JsonData.buildSuccess();
	}

	/**
	 * 更新用户信息
	 * @param name
	 * @param id
	 * @return
	 */
	@GetMapping("update")
	public Object update(String name,int id){
		User user = new User();
		user.setName(name);
		user.setId(id);
		userMapper.update(user);
	    return JsonData.buildSuccess();
	}


	//测试事务
	@GetMapping("transacTest")
	public Object transacTest(){
		int id = userService.addAccount();
		return JsonData.buildSuccess(id);
	}






	
	
}
