package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Grade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description gradeMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface GradeMapper extends BaseMapper<Grade> {

    int countAll(Grade queryParamDTO);

}
