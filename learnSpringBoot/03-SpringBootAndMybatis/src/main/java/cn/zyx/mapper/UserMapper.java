package cn.zyx.mapper;



import cn.zyx.domain.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 功能描述：访问数据库的接口
 *
 * <p> 创建时间：May 6, 2018 3:51:49 PM </p> 
 *
 *@作者 小D课堂  小D
 */

public interface UserMapper {
	
	
	//推荐使用#{}取值，不要用${},因为存在注入的风险
	 @Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
	 @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")   //keyProperty java对象的属性；keyColumn表示数据库的字段
	 int insert(User user);

	/**
	 * 查找全部
	 * @return
	 */
	@Select("SELECT * FROM user")
	@Results({
			@Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
			//column 是数据库中对应字段名   property是对象中的字段名  用于字段名不一致转换匹配
	})
	List<User> getAll();

	/**
	 * 根据id找对象
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
			@Result(column = "create_time",property = "createTime")
	})
	User findById(Long id);

	/**
	 * 更新对象
	 * @param user
	 */
	@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
	void update(User user);

	/**
	 * 根据id删除对象
	 * @param userId
	 */
	@Delete("DELETE FROM user WHERE id =#{userId}")
	void delete(Long userId);
}