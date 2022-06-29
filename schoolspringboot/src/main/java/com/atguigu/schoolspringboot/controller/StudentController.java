package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.Student;
import com.atguigu.schoolspringboot.service.StudentService;
import com.atguigu.schoolspringboot.utils.RespResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/28 19:47
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Student student) {
        if (student.getId() == null) {
//            设置默认头像
            if (student.getAvator() == null | student.getAvator().length() <= 0) {
                student.setAvator("http://localhost:8080" + "/images/img.png");
            }
            studentService.save(student);
        } else {
            studentService.updateById(student);
        }
        return RespResult.success();
    }


    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Integer id) {
        studentService.removeById(id);
        return RespResult.success();
    }

    @PostMapping("/del/batch")
    public Object deleteBatch(@RequestBody List<Integer> ids) {
        studentService.removeByIds(ids);
        return RespResult.success();
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Integer id) {
        return RespResult.success(studentService.getById(id));
    }


    @GetMapping("/page")
    public Object findPage(@RequestParam(name = "name", required = false, defaultValue = "") String name, Integer page, Integer limit) {
        Page pageResult = studentService.findPage(name, page, limit);
        return new RespResult("0", "查询成功", pageResult.getRecords(), (int) pageResult.getTotal());
    }


}
