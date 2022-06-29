package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description studentMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    int countAll(Student queryParamDTO);

}
