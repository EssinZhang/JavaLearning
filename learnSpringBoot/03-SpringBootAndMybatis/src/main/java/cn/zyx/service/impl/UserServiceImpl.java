package cn.zyx.service.impl;

import cn.zyx.domain.User;
import cn.zyx.mapper.UserMapper;
import cn.zyx.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	 private UserMapper userMapper;
	 
	@Override
	public int add(User user) {
		userMapper.insert(user);
		int id = user.getId();
		return id;
	}


	@Override
	/**
	 * 事务处理  要加Transaction注解
	 */
	@Transactional(propagation= Propagation.REQUIRED)
	public int addAccount(){
		User user = new User();
		user.setAge(11);
		user.setCreateTime(new Date());
		user.setName("KobeBryant");
		user.setPhone("10010000");
		userMapper.insert(user);
		int i = 19/0;

		return 0;
	}

	
	
}
