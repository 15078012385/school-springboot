package com.atguigu.schoolspringboot.controller;

import com.atguigu.schoolspringboot.pojo.DataStatistic;
import com.atguigu.schoolspringboot.service.*;
import com.atguigu.schoolspringboot.utils.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/6/29 10:38
 */
@RestController
@RequestMapping("/dataStatistics")
public class DataStatisticsController {

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SysClassService sysClassService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public Object countData() {
        ArrayList<DataStatistic> dataStatistics = new ArrayList<>();
        dataStatistics.add(new DataStatistic(studentService.count(), "学生数量"));
        dataStatistics.add(new DataStatistic(teacherService.count(), "教师数量"));
        dataStatistics.add(new DataStatistic(sysClassService.count(), "班级数量"));
        dataStatistics.add(new DataStatistic(gradeService.count(), "年级数量"));
        dataStatistics.add(new DataStatistic(messageService.count(), "留言数量"));
        dataStatistics.add(new DataStatistic(announcementService.count(), "公告数量"));
        return new RespResult<>("200", "统计成功", dataStatistics, null);
    }


}
