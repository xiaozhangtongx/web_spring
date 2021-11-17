package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @version 1.0
 * @TODO 查询用户信息
 * @date 2021/11/17 星期三 16:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchParam {
    private String username;
    private String email;
    private Integer page;
    private Integer pageSize;
}
