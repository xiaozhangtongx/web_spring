package com.demon.spring.controller;


import com.demon.spring.pojo.User;
import com.demon.spring.service.impl.UserServiceImpl;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserEditParam;
import com.demon.spring.utils.UserLoginParam;
import com.demon.spring.utils.UserSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 测试
     *
     * @return 测试结果
     */
    @RequestMapping("/test")
    public String test() {
        return "hello";
    }


    /**
     * 用户登录
     *
     * @param userLoginParam 用户登录信息
     * @return 当前用户的信息
     */
    @RequestMapping("/login")
    public RespBean userLogin(@RequestBody UserLoginParam userLoginParam) {
        System.out.println(userLoginParam);
        return userService.userLogin(userLoginParam);
    }

    /**
     * 用户注册
     *
     * @param user 注册用户的信息
     * @return 注册的结果
     */
    @RequestMapping("/register")
    public RespBean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 获得用户列表
     *
     * @param userSearchParam 查询用户信息
     * @return 用户列表
     */
    @RequestMapping("/users")
    public RespBean getUsers(@RequestBody UserSearchParam userSearchParam) {
        return userService.getUsers(userSearchParam);
    }

    /**
     * 通过名字查询用户
     *
     * @param username 用户名
     * @return 查询的结果
     */
    @RequestMapping("/getuser")
    public RespBean getUserByname(String username) {
        return userService.getUserByname(username);
    }

    /**
     * 修改用户信息
     *
     * @param user 修改的用户信息
     * @return 修改后的结果
     */
    @RequestMapping("/edituser")
    public RespBean editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    /**
     * 修改用户密码
     *
     * @param user 要修改的用户信息
     * @return 修改的结果
     */
    @RequestMapping("/changepwd")
    public RespBean changePwd(@RequestBody User user) {
        return userService.changePwd(user);
    }

    /**
     * 删除用户
     *
     * @param username 要删除的用户名
     * @return 删除的结果
     */
    @RequestMapping("/deleteuser")
    public RespBean deleteUser(String username) {
        return userService.deleteUser(username);
    }
}

