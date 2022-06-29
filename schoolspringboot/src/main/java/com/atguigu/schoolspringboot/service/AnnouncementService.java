package com.atguigu.schoolspringboot.service;

import com.atguigu.schoolspringboot.pojo.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @description announcement服务层
 * @author xiaochen
 * @date 2022-06-22
 */
public interface AnnouncementService extends IService<Announcement> {
    public Page findPage(String name, Integer page, Integer limit);
}
