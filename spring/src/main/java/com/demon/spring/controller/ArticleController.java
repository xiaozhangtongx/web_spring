package com.demon.spring.controller;


import com.demon.spring.service.impl.ArticleServiceImpl;
import com.demon.spring.utils.ArticleSearchParam;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping("/articles")
    public RespBean getArticles(@RequestBody UserSearchParam userSearchParam) {
        return articleService.getArticles(userSearchParam);
    }

    @RequestMapping("/getarticles")
    public RespBean getArticlesByname(@RequestBody ArticleSearchParam searchParam) {
        return articleService.getArticlesByname(searchParam);
    }
}

