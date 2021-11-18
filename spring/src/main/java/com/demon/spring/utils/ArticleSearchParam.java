package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @version 1.0
 * @TODO 文章搜索信息类
 * @date 2021/11/18 星期四 17:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSearchParam {
    private String name;
    private Integer page;
    private Integer pageSize;
    private String username;
}
