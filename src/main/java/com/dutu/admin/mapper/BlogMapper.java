package com.dutu.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dutu.admin.bean.Blog;

/**
 * @author dutu
 * @date 2021-03-26 20:22
 */
public interface BlogMapper extends BaseMapper<Blog> {
    int insertBlogByBtid(Blog blog);
}
