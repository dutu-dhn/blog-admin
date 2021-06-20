package com.dutu.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author dutu
 * @date 2021-03-27 13:27
 */
@Data
public class Blable {
    @TableId(value = "blid",type = IdType.AUTO)
    private Integer blid;
    private String blname;
}
