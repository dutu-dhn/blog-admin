package com.dutu.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dutu.admin.bean.Admin;
import com.dutu.admin.bean.Blable;

import com.dutu.admin.bean.Blog;
import com.dutu.admin.bean.Bt;
import com.dutu.admin.mapper.BlableMapper;
import com.dutu.admin.mapper.BlogMapper;
import com.dutu.admin.mapper.BtMapper;
import com.dutu.admin.service.BlogService;
import com.dutu.admin.util.MyTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dutu
 * @date 2021-03-27 23:38
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements BlogService{
    @Autowired
    BlableMapper blableMapper;

    @Autowired
    BtMapper btMapper;

    @Autowired
    BlogMapper blogMapper;
    @Override
    public List<Blable> getLable() {
        List<Blable> blableList = blableMapper.selectList(null);
        return blableList;
    }

    @Override
    public int saveBt(Bt bt) {
        return btMapper.insertAndGetId(bt);
    }

    @Override
    public int saveBlog(Blog blog) {

        String time = MyTimeUtil.getTime();
        blog.setUpdtime(time);

        return blogMapper.insertBlogByBtid(blog);
    }

    @Override
    public List<Blog> getList() {
        return blogMapper.selectList(null);
    }
}
