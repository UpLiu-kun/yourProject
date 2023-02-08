package com.example.yourproject.userManage.service.impl;

import com.example.yourproject.userManage.bean.User;
import com.example.yourproject.userManage.dao.UserMapper;
import com.example.yourproject.userManage.service.UserService;
import com.example.yourproject.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @创建人 LiuKun
 * @创建时间 UserServiceImpl$
 * @描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper umapper;

//    @Autowired
//    EmployeeMapper emapper;
//    @Autowired2
//    WageconfigMapper wmapper;

    @Override
    public Result userLogin(String uid, String password) {

        //根据用户账号密码获得对应的用户
        User user = umapper.find(uid);
        //用户不存在user表中，重新登录
        if(null == user) {
            return Result.error("当前用户不存在");
        }
        user = umapper.findUser(uid, password);
        if(null == user) {
            return Result.error("密码错误");
        }
        return Result.success();
////        //获得员工信息
////        Employee employee = emapper.findByEid(uid);
////        //获得职位信息
////        WageConfig wageconfig=wmapper.getWageconfig(employee.getWid());
//
//        //不为空，将账号密码保存在session里
//        session.setAttribute("UID", user.getUid());
//        session.setAttribute("PASSWD", user.getPassword());
//        session.setAttribute("QUA", user.getPermission());
////        session.setAttribute("EMAIL", employee.getEmail());
////        session.setAttribute("PHONE", employee.getPhone());
////        session.setAttribute("IMG", employee.getPicture());
//        System.out.println(user.getPermission());
////        session.setAttribute("NAME", employee.getEname());
////        session.setAttribute("DUTY", wageconfig.getPosition());
////        session.setAttribute("DNO", wageconfig.getDno());
////        session.setAttribute("BASEWAGE", wageconfig.getBaseWage());
//        if(user.getPermission().equals("admin")) {
//            return "mlogin.html";
//        }
//        else
//
//            return "employee.html";

    }

    @Override
    public boolean addUser(User user) {
        if(user.getUid()=="") {
            return false;
        }

        else {
            user.setEid(user.getUid());
            user.setPassword(user.getUid());
            user.setPermission(user.getPermission()==""?"gener":"admin");
            //创建
            umapper.create(user);
            return true;
        }
    }

    @Override
    public boolean delUser(String eid) {
        if(umapper.remove(eid)) {

            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> getUsers(){
//        List<User> users = umapper.findAll();
//        for(User user:users) {
//            //密码保护
//            user.setPassword("******");
//        }
        return null;
    }

    @Override
    public String checkpwd(HashMap<String, String> map, String employeeID) {
        String pwd = umapper.getpwd(employeeID);
        if (!map.get("oldpwd").equals(pwd)) {
            return "erropwd";
        }

        if (!map.get("pwd1").equals(map.get("pwd2"))) {
            return "noequal";
        }

        if (map.get("pwd1").equals(map.get("pwd2")))

            umapper.changepwd(employeeID, map.get("pwd2"));
        return "ok";
    }

}
