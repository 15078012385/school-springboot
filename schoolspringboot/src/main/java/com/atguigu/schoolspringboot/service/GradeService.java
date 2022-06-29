package com.atguigu.schoolspringboot.service;

import com.atguigu.schoolspringboot.pojo.Grade;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * @description grade服务层
 * @author xiaochen
 * @date 2022-06-22
 */
public interface GradeService extends IService<Grade> {
    public Page findPage(String name, Integer page, Integer limit);
}

