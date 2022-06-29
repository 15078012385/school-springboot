package com.atguigu.schoolspringboot.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.schoolspringboot.dao.AdminMapper;
import com.atguigu.schoolspringboot.pojo.Admin;
import com.atguigu.schoolspringboot.service.AdminService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 8:45
 */
@Slf4j
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {




}
