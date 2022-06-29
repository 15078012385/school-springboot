package com.atguigu.schoolspringboot.service;

import com.atguigu.schoolspringboot.pojo.Student;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description student服务层
 * @author xiaochen
 * @date 2022-06-22
 */
public interface StudentService extends IService<Student> {

    public Page findPage(String name, Integer page, Integer limit);

}
