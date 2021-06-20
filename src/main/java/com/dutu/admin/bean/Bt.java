package com.dutu.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author dutu
 * @date 2021-03-26 20:20
 */
@Data
public class Bt {
    @TableId(value = "btid",type = IdType.AUTO)
    private Integer btid;
    private String bt;
}
