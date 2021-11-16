package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @version 1.0
 * @TODO 用户登录实体类
 * @date 2021/11/16 星期二 9:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginParam {
    private String username;
    private Integer password;
}
