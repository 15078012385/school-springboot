package com.atguigu.schoolspringboot.service.impl;

import com.atguigu.schoolspringboot.dao.AnnouncementMapper;
import com.atguigu.schoolspringboot.dao.StudentMapper;
import com.atguigu.schoolspringboot.pojo.Announcement;
import com.atguigu.schoolspringboot.pojo.Student;
import com.atguigu.schoolspringboot.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 9:02
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page findPage(String name, Integer page, Integer limit) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        if (name != null) {
            if (!"".equals(name)) {
                wrapper.like("username", name);
            }
        }
//        mybatis分页插件，在xml配置。mp插件，需创建配置类拦截sql.
        Page<Student> pageResult = studentMapper.selectPage(new Page<>(page, limit), wrapper);
        return pageResult;
    }

}
