package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.SysClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description sys_classMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface SysClassMapper extends BaseMapper<SysClass> {

    int countAll(SysClass queryParamDTO);

}
