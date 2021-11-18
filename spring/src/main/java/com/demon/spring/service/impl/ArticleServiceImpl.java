package com.demon.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demon.spring.mapper.ArticleMapper;
import com.demon.spring.pojo.Article;
import com.demon.spring.pojo.User;
import com.demon.spring.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demon.spring.utils.ArticleSearchParam;
import com.demon.spring.utils.RespBean;
import com.demon.spring.utils.UserSearchParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    public ArticleMapper articleMapper;

    @Override
    public RespBean getArticles(UserSearchParam userSearchParam) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("count(*) as nums,username").like("username", userSearchParam.getUsername()).groupBy("username").orderByDesc("nums");
//        List<Map<String, Object>> articles = articleMapper.selectMaps(queryWrapper);
        IPage<Map<String, Object>> page = new Page<>(userSearchParam.getPage(), userSearchParam.getPageSize());
        IPage<Map<String, Object>> mapIPage = articleMapper.selectMapsPage(page, queryWrapper);
        long total = page.getTotal();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("users", mapIPage);
        System.out.println(mapIPage.getSize());
        RespBean respBean = new RespBean();
        if (mapIPage.getSize() == 0) {
            respBean = respBean.error("暂无文章！");
        } else {
            respBean = respBean.success("用户文章列表更新成功！", map);
        }
        return respBean;
    }

    @Override
    public RespBean getArticlesByname(ArticleSearchParam searchParam) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", searchParam.getUsername()).like("name", searchParam.getName()).orderByDesc("uploaded");
        IPage<Map<String, Object>> page = new Page<>(searchParam.getPage(), searchParam.getPageSize());
        IPage<Map<String, Object>> mapIPage = articleMapper.selectMapsPage(page, queryWrapper);
        System.out.println(mapIPage);
        RespBean respBean = new RespBean();
        if (mapIPage.getSize() == 0) {
            respBean = respBean.error("暂无文章！");
        } else {
            respBean = respBean.success("用户文章列表更新成功！", mapIPage);
        }
        return respBean;
    }

}
