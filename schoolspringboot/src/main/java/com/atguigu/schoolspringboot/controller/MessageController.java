package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.Grade;
import com.atguigu.schoolspringboot.pojo.Message;
import com.atguigu.schoolspringboot.service.MessageService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/29 9:44
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Message message) {
        if (message.getId() == null) {
            messageService.save(message);
        } else {
            messageService.updateById(message);
        }
        return RespResult.success();
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        messageService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        messageService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(messageService.getById(id));
    }

    @GetMapping()
    public Object findAll() {
        return new RespResult<>("200", "查询成功", messageService.list());
    }

    @GetMapping("/page")
    public Object findPage(@RequestParam(name = "name", required = false, defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = messageService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }


}

