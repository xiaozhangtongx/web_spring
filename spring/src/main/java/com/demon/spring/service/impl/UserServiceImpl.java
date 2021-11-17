package com.demon.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demon.spring.pojo.User;
import com.demon.spring.mapper.UserMapper;
import com.demon.spring.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserEditParam;
import com.demon.spring.utils.UserLoginParam;
import com.demon.spring.utils.UserSearchParam;
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

    @Override
    public RespBean getUsers(UserSearchParam userSearchParam) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", userSearchParam.getUsername())
                .like("email", userSearchParam.getEmail())
                .eq("role", "user");
        Page<User> page = new Page<>(userSearchParam.getPage(), userSearchParam.getPageSize());
        IPage<User> userPage = userMapper.selectPage(page, queryWrapper);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("users", records);
        RespBean respBean = new RespBean();
        if (records.isEmpty()) {
            respBean = respBean.error("该用户不不存在！");
        } else {
            respBean = respBean.success("用户列表更新成功", map);
        }
        return respBean;
    }

    @Override
    public RespBean getUserByname(String username) {
        QueryWrapper<User> wrapperUser = new QueryWrapper<>();
        wrapperUser.eq("username", username);
        List<User> users = userMapper.selectList(wrapperUser);
        System.out.println(users);
        RespBean respBean = new RespBean();
        if (users.isEmpty()) {
            respBean = respBean.error("该用户不不存在！");
        } else {
            respBean = respBean.success("查找成功", users);
        }
        return respBean;
    }

    @Override
    public RespBean editUser(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", user.getUsername()).set("email", user.getEmail()).set("birthday", user.getBirthday());
        Integer rows = userMapper.update(null, updateWrapper);
        System.out.println(rows);
        RespBean respBean = new RespBean();
        if (rows != 1) {
            respBean = respBean.error("修改失败");
        } else {
            respBean = respBean.success("修改成功");
        }
        return respBean;
    }

    @Override
    public RespBean deleteUser(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
        RespBean respBean = new RespBean();
        if (i != 1) {
            respBean = respBean.error("删除失败");
        } else {
            respBean = respBean.success("删除成功");
        }
        return respBean;
    }
}
