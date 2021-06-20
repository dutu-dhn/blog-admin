package com.dutu.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dutu.admin.bean.Admin;
import com.dutu.admin.mapper.AdminMapper;
import com.dutu.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dutu
 * @date 2021-03-27 20:28
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin checkAdminLogin(Admin admin) {

        QueryWrapper<Admin> wrapper = Wrappers.query();

        String uname = admin.getUname();
        String password = admin.getPassword();

        wrapper.eq("uname", uname).eq("password", password);
        List<Admin> adminList = adminMapper.selectList(wrapper);
        if (adminList.size() == 1){
            return adminList.get(0);
        }
        else {return null;}
    }
}
