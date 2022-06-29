package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description teacherMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    int countAll(Teacher queryParamDTO);

}
