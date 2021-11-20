package com.demon.spring.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang
 * @version 1.0
 * @TODO 文章计数
 * @date 2021/11/19 星期五 19:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCount {
    private int count;
    private int month;
}
