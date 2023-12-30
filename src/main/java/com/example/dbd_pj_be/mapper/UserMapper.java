package com.example.dbd_pj_be.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dbd_pj_be.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    

}
