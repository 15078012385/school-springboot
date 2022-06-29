package com.atguigu.schoolspringboot.service.impl;

import com.atguigu.schoolspringboot.dao.AnnouncementMapper;
import com.atguigu.schoolspringboot.dao.GradeMapper;
import com.atguigu.schoolspringboot.pojo.Announcement;
import com.atguigu.schoolspringboot.pojo.Grade;
import com.atguigu.schoolspringboot.pojo.SysClass;
import com.atguigu.schoolspringboot.service.GradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 9:00
 */
@Slf4j
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Page findPage(String name, Integer page, Integer limit) {
        QueryWrapper<Grade> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
//        mybatis分页插件，在xml配置。mp插件，需创建配置类拦截sql.
        Page<Grade> pageResult = gradeMapper.selectPage(new Page<>(page, limit), wrapper);
        return pageResult;
    }
}
