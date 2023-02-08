package com.example.yourproject.userManage.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户
 * 
 * @author xxm
 *
 */
@Data
public class User {

	@ApiModelProperty(value = "登录账号")
	String uid;
	@ApiModelProperty(value = "密码")
	String password;
	@ApiModelProperty(value = "权限：管理员、一般用户")
	String permission;
	@ApiModelProperty(value = "员工号")
	String eid;
}
