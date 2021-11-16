package com.demon.spring.service;

import com.demon.spring.mapper.UserMapper;
import com.demon.spring.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserLoginParam;
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
}
