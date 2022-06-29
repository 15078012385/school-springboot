package com.atguigu.schoolspringboot.service.impl;

import com.atguigu.schoolspringboot.dao.AnnouncementMapper;
import com.atguigu.schoolspringboot.dao.MessageMapper;
import com.atguigu.schoolspringboot.pojo.Announcement;
import com.atguigu.schoolspringboot.pojo.Grade;
import com.atguigu.schoolspringboot.pojo.Message;
import com.atguigu.schoolspringboot.service.MessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 9:01
 */
@Slf4j
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public Page findPage(String name, Integer page, Integer limit) {
        QueryWrapper<Message> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
//        mybatis分页插件，在xml配置。mp插件，需创建配置类拦截sql.
        Page<Message> pageResult = messageMapper.selectPage(new Page<>(page, limit), wrapper);
        return pageResult;
    }

}
