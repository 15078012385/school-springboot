package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.Teacher;
import com.atguigu.schoolspringboot.service.TeacherService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/29 8:14
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Teacher teacher) {
        if (teacher.getId() == null) {
            //            设置默认头像
            if (teacher.getAvator() == null | teacher.getAvator().length() <= 0) {
                teacher.setAvator("http://localhost:8080" + "/images/img.png");
            }
            teacherService.save(teacher);
        } else {
            teacherService.updateById(teacher);
        }
        return RespResult.success();
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        teacherService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        teacherService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(teacherService.getById(id));
    }


    @GetMapping("/page")
    public Object findPage(@RequestParam(name = "name", required = false, defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = teacherService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }

}
