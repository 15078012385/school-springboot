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
 * @description sys_class
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_class")
public class SysClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 班级id
     */
    private Integer id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级人数
     */
    private String studentCount;

    /**
     * 班主任
     */
    private String teacher;

    /**
     * 所属年级
     */
    private String grade;

    /**
     * 班级介绍
     */
    private String classIntroduction;

}
