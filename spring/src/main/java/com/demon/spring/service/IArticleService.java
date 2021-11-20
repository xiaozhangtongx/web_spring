package com.demon.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demon.spring.pojo.Article;
import com.demon.spring.utils.ArticleSearchParam;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserSearchParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
public interface IArticleService extends IService<Article> {

    /**
     * 通过用户名获取文章列表
     *
     * @param userSearchParam 搜索的信息
     * @return 用户文章列表
     */
    public RespBean getArticles(UserSearchParam userSearchParam);

    /**
     * 通过文章名获取文章
     *
     * @param searchParam 查询的用户信息
     * @return
     */
    public RespBean getArticlesByname(ArticleSearchParam searchParam);

    /**
     * 发表文章
     *
     * @param article 发表文章的信息
     * @return 发表文章的结果
     */
    public RespBean addArticle(Article article);

    /**
     * 修改文章信息
     *
     * @param article 要修改的文章信息
     * @return 修改的结果
     */
    public RespBean editArticle(Article article);

    /**
     * 删除文章
     *
     * @param name 文章名
     * @return 删除的结果
     */
    public RespBean deleteArticle(String name);

    /**
     * 查询用户每个月发表文章的数目
     *
     * @param username 用户名
     * @return 查询的数据
     */
    public RespBean getArticleCount(String username);
}
