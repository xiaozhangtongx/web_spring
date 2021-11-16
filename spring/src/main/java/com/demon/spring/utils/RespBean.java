package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhang
 * @version 1.0
 * @TODO 公共返回对象
 * @date 2021/11/16 星期二 9:23
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回
     *
     * @param message 返回的信息
     * @return 返回成功的信息
     */
    public RespBean success(String message) {
        return new RespBean(200, message, null);
    }

    /**
     * 成功返回
     *
     * @param message
     * @param obj
     * @return 返回成功的信息
     */
    public RespBean success(String message, Object obj) {
        return new RespBean(200, message, obj);
    }

    public  RespBean error(String message) {
        return new RespBean(500, message, null);
    }

    public  RespBean error(String message, Object obj) {
        return new RespBean(500, message, obj);
    }
}
