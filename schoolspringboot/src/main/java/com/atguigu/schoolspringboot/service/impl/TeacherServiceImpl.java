package com.atguigu.schoolspringboot.service.impl;

import com.atguigu.schoolspringboot.dao.AnnouncementMapper;
import com.atguigu.schoolspringboot.dao.TeacherMapper;
import com.atguigu.schoolspringboot.pojo.Announcement;
import com.atguigu.schoolspringboot.pojo.SysClass;
import com.atguigu.schoolspringboot.pojo.Teacher;
import com.atguigu.schoolspringboot.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 9:03
 */
@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page findPage(String name, Integer page, Integer limit) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        if (name != null) {
            if (!"".equals(name)) {
                wrapper.like("username", name);
            }
        }
//        mybatis分页插件，在xml配置。mp插件，需创建配置类拦截sql.
        Page<Teacher> pageResult = teacherMapper.selectPage(new Page<>(page, limit), wrapper);
        return pageResult;
    }
}
