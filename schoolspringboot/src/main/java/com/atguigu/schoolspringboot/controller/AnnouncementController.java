package com.atguigu.schoolspringboot.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.schoolspringboot.pojo.Announcement;
import com.atguigu.schoolspringboot.service.AnnouncementService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 14:10
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;


    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Announcement announcement) {
        announcement.setPublishTime(DateUtil.format(new Date(), "yyyy年-MM月-dd日"));
        if (announcementService.getById(announcement.getId()) == null) {
            announcementService.save(announcement);
        } else {
            announcementService.updateById(announcement);
        }
        return RespResult.success();
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        announcementService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        announcementService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping()
    public Object findAll() {
        return new RespResult<>("200", "查询成功", announcementService.list());
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(announcementService.getById(id));
    }


    @GetMapping("/page")
    public Object findPage(@RequestParam(defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = announcementService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }




}
