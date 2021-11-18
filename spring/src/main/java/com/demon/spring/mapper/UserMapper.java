package com.demon.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demon.spring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取所有的用户信息
     *
     * @return 所有的用户信息
     */
    public List<User> getAllUsers();

    /**
     * 根据用户输入的信息判断是否成功
     *
     * @param username 用户名
     * @param password 登录密码
     * @return 用户信息
     */
    public User getUserByMessage(String username, Integer password);
}
