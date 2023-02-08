package com.example.yourproject.userManage.dao;

import com.example.yourproject.userManage.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

	/**
	 * 根据用户账号和密码查询用户信息
	 * @param uid 账号
	 * @param password 密码
	 * @return
	 */
	 User findUser(@Param("uid") String uid, @Param("password") String password);
	
	//根据账号查询用户
	 User find(@Param("uid") String uid);
	
	
	/**
	 * 根据账号删除用户
	 * @param uid 账号
	 */
	 boolean remove(String uid);
	
//	/**
//	 * 查询所有用户信息
//	 * @return 用户列表
//	 */
//	@Select("select * from user")
//	 List<User> findAll();
	
	/**
	 * 添加新的用户
	 * @param u
	 */
	 void create(User u);
	
	//获得密码
	 String getpwd(String uid);
	
	//修改密码
	 int changepwd(@Param("uid") String uid, @Param("password") String password);
}
