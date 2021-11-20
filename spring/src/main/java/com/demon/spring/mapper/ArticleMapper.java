package com.demon.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demon.spring.pojo.Article;
import com.demon.spring.utils.ArticleCount;
import com.demon.spring.utils.RespBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    public List<ArticleCount> getArticleCount(String username);
}
