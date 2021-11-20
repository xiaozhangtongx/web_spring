package com.demon.spring.service;

import com.demon.spring.mapper.UserMapper;
import com.demon.spring.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserEditParam;
import com.demon.spring.utils.UserLoginParam;
import com.demon.spring.utils.UserSearchParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
public interface IUserService extends IService<User> {
    /**
     * 获取所有的用户信息
     *
     * @return 用户信息
     */
    public List<User> getAllUsers();

    /**
     * 用户登录
     *
     * @param userLoginParam 用户登录信息
     * @return 登录状态
     */
    public RespBean userLogin(UserLoginParam userLoginParam);

    /**
     * 用户查询
     *
     * @return 查询的用户信息
     */
    public RespBean getUsers(UserSearchParam userSearchParam);

    /**
     * 通过用户吗获取用户的信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    public RespBean getUserByname(String username);

    /**
     * 修改用户
     *
     * @param user 修改的用户信息
     * @return 修改后的结果
     */
    public RespBean editUser(User user);

    /**
     * 删除用户
     *
     * @param username 用户名
     * @return 删除是结果
     */
    public RespBean deleteUser(String username);

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 添加的结果
     */
    public RespBean addUser(User user);

    /**
     * 修改登录密码
     *
     * @param user 用户信息
     * @return 修改的结果
     */
    public RespBean changePwd(User user);
}
