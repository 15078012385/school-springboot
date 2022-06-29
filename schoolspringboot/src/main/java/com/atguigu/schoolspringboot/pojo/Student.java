package com.atguigu.schoolspringboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaochen
 * @description student
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 学生id
     */
    private Integer id;

    /**
     * 所属班级
     */
    private String studentClass;

    /**
     * 姓名
     */
    private String username;

    /**
     * 头像
     */
    private String avator;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 性别
     */
    private String gender;

    /**
     * 介绍
     */
    private String introduction;

}
