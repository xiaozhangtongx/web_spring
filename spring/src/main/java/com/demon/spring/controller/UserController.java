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

    @RequestMapping("/test")
    public String test() {
        return "hello";
    }


    @RequestMapping("/login")
    public RespBean userLogin(@RequestBody UserLoginParam userLoginParam) {
        return userService.userLogin(userLoginParam);
    }

    @RequestMapping("/users")
    public RespBean getUsers(@RequestBody UserSearchParam userSearchParam) {
        return userService.getUsers(userSearchParam);
    }

    @RequestMapping("/getuser")
    public RespBean getUserByname(String username) {
        return userService.getUserByname(username);
    }

    @RequestMapping("/edituser")
    public RespBean editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @RequestMapping("/deleteuser")
    public RespBean deleteUser(String username) {
        return userService.deleteUser(username);
    }
}

