package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhang
 * @version 1.0
 * @TODO 用户修改表单
 * @date 2021/11/17 星期三 21:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditParam {
    private String username;
    private String email;
    private Date birthday;
}
