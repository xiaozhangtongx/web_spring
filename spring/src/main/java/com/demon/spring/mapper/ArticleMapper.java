package com.demon.spring.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demon.spring.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhang
 * @since 2021-11-16
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
