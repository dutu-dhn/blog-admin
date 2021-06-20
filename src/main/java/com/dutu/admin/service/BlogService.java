package com.dutu.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dutu.admin.bean.Blable;
import com.dutu.admin.bean.Blog;
import com.dutu.admin.bean.Bt;

import java.util.List;

/**
 * @author dutu
 * @date 2021-03-27 23:38
 */
public interface BlogService extends IService<Blog> {
    List<Blable> getLable();

    int saveBt(Bt bt);

    int saveBlog(Blog blog);

    List<Blog> getList();
}
