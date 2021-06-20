package com.dutu.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;

    private String uname;

    private String password;

    private String signature;

    private String qq;

    private String email;

    private String address;

    private String imgpath;

  
}