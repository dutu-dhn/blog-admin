package com.dutu.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dutu.admin.bean.Bt;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author dutu
 * @date 2021-03-26 20:22
 */

public interface BtMapper extends BaseMapper<Bt> {
    int insertAndGetId(Bt bt);
}
