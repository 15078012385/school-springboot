package com.atguigu.schoolspringboot.service;

import com.atguigu.schoolspringboot.pojo.Teacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description teacher服务层
 * @author xiaochen
 * @date 2022-06-22
 */
public interface TeacherService extends IService<Teacher> {
    public Page findPage(String name, Integer page, Integer limit);
}
