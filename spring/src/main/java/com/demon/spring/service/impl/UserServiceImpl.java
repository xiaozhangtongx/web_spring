package com.demon.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demon.spring.pojo.User;
import com.demon.spring.mapper.UserMapper;
import com.demon.spring.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    public UserMapper userMapper;

    /**
     * 获取所有的用户信息
     *
     * @return 用户信息
     */
    @Override
    public List<User> getAllUsers() {
        System.out.println("hello");
        return userMapper.selectList(null);
    }

    /**
     * 用户登录
     *
     * @param userLoginParam 用户登录信息
     * @return 用户登录结果
     */
    @Override
    public RespBean userLogin(UserLoginParam userLoginParam) {
        QueryWrapper<User> wrapperUser = new QueryWrapper<>();
        wrapperUser.eq("username", userLoginParam.getUsername())
                .eq("password", userLoginParam.getPassword());
        List<User> users = userMapper.selectList(wrapperUser);
        RespBean respBean = new RespBean();
        if (users.isEmpty()) {
            System.out.println("密码错误");
            respBean = respBean.error("账号或密码输入错误，请重新输入你的账号和密码");
        } else {
            respBean = respBean.success("账号密码，输入正确", users);
        }
        return respBean;
    }
}
