package com.example.yourproject.userManage.service;

import java.util.HashMap;
import java.util.List;

import com.example.yourproject.userManage.bean.User;
import com.example.yourproject.common.util.Result;

/**
 * user页面跳转
 * 
 * @author xxm
 *
 */
public interface UserService {
	
	/**
	 * 检查用户登录    验证身份    并跳转页面
	 * @param uid 账号
	 * @param password 密码
	 * @param
	 * @return
	 */
	Result userLogin(String uid, String password);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) ;

	/**
	 * 删除用户
	 * @param eid 员工号/账号
	 * @return
	 */
	public boolean delUser(String eid);

	/**
	 * 得到所有用户
	 * @return 用户列表
	 */
	public List<User> getUsers();
	
	/**
	 * 修改密码
	 * @param map
	 * @param employeeID
	 * @return
	 */
	public String checkpwd(HashMap<String, String> map, String employeeID) ;
}


