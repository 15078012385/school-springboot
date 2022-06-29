package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * @description adminMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
