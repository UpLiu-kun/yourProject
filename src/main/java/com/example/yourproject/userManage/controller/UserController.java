package com.example.yourproject.userManage.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.yourproject.userManage.bean.User;
import com.example.yourproject.userManage.service.UserService;
import com.example.yourproject.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/user")
@Api(value = "用户登录API")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/userLogin")
	@ApiOperation(value = "用户登录")
	public Result userLogin(@RequestBody  User user, HttpServletRequest req) {
		return userService.userLogin(user.getUid(), user.getPassword());
	}
	
	@PostMapping("/addUser")
	@ApiOperation(value = "添加新的用户信息")
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/delUser")
	@ApiOperation(value = "删除用户")
	public boolean delUser(@RequestBody String uid) {
		return userService.delUser(uid);
	
	}
	
	@GetMapping("/back")
	@ApiOperation(value = "删除用退出户")
	public String back(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("UID");
		return "login";
	}

	@PostMapping("/changpwd")
	@ApiOperation(value = "修改密码")
	public String changepwd(@RequestBody HashMap<String, String>map,HttpServletRequest req) {
		HttpSession session = req.getSession();
		String EmployeeID = (String) session.getAttribute("UID");
		return userService.checkpwd(map,EmployeeID);
	}
	
}
