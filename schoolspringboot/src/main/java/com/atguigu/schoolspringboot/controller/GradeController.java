package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.Grade;
import com.atguigu.schoolspringboot.service.GradeService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/29 9:14
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Grade grade) {
        if (grade.getId() == null) {
            gradeService.save(grade);
        } else {
            gradeService.updateById(grade);
        }
        return RespResult.success();
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        gradeService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        gradeService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(gradeService.getById(id));
    }

    @GetMapping
    public Object findAll() {
        return RespResult.success(gradeService.list());
    }

    @GetMapping("/page")
    public Object findPage(@RequestParam(name = "name", required = false, defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = gradeService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }

}
