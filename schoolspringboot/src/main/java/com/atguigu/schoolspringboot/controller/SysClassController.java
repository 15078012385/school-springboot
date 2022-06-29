package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.SysClass;
import com.atguigu.schoolspringboot.service.SysClassService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/29 7:48
 */
@RestController
@RequestMapping("/sysClass")
public class SysClassController {

    @Autowired
    private SysClassService sysClassService;

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody SysClass sysClass) {
        if (sysClass.getId() == null) {
            sysClassService.save(sysClass);
        } else {
            sysClassService.updateById(sysClass);
        }
        return RespResult.success();
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        sysClassService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        sysClassService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(sysClassService.getById(id));
    }

    @GetMapping
    public Object findAll() {
        return RespResult.success(sysClassService.list());
    }

    @GetMapping("/page")
    public Object findPage(@RequestParam(name = "name", required = false, defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = sysClassService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }


}
