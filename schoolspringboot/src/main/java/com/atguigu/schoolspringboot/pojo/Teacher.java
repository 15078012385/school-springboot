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
 * @description teacher
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 教师id
     */
    private Integer id;

    /**
     * 任课班级
     */
    private String teachClass;

    /**
     * 教师姓名
     */
    private String username;

    /**
     * 教师头像
     */
    private String avator;

    /**
     * 工号
     */
    private String workNumber;

    /**
     * 性别
     */
    private String gender;

}
