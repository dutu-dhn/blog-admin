package com.dutu.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author dutu
 * @date 2021-03-26 22:40
 */
@Data
public class Blog {
    @TableId(value = "bid",type = IdType.AUTO)
    private Integer bid;

    private String title;

    private String description;

    private String lableid;

    private String type;

    private String updtime;

    private String browse;

    private String leaveamessage;


}
