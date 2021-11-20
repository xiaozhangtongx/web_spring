package com.demon.spring.controller;


import com.demon.spring.pojo.Article;
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

    /**
     * 获取用户发表文章的数目
     *
     * @param userSearchParam 查询的用户信息
     * @return 用户发文的数量
     */
    @RequestMapping("/articles")
    public RespBean getArticles(@RequestBody UserSearchParam userSearchParam) {
        return articleService.getArticles(userSearchParam);
    }

    /**
     * 获取用户发表的文章
     *
     * @param searchParam 文章查询的信息
     * @return 用户文章列表
     */
    @RequestMapping("/getarticles")
    public RespBean getArticlesByname(@RequestBody ArticleSearchParam searchParam) {
        return articleService.getArticlesByname(searchParam);
    }

    /**
     * 发表文章
     *
     * @param article 发表文章的信息
     * @return 发表的结果
     */
    @RequestMapping("/addarticle")
    public RespBean addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    /**
     * 修改文章
     *
     * @param article 要修改的文章信息
     * @return 修改的结果
     */
    @RequestMapping("/editarticle")
    public RespBean editArticle(@RequestBody Article article) {
        return articleService.editArticle(article);
    }

    /**
     * 通过文章名称删除文章
     *
     * @param name 文章名称
     * @return 删除的结果
     */
    @RequestMapping("/deletearticle")
    public RespBean deleteArticle(String name) {
        return articleService.deleteArticle(name);
    }

    /**
     * 获取用户每月发表文章的数量
     *
     * @param username 用户名
     * @return 用户每月发表文章的数量
     */
    @RequestMapping("/getcount")
    public RespBean getArticleCount(String username) {
        return articleService.getArticleCount(username);
    }
}

