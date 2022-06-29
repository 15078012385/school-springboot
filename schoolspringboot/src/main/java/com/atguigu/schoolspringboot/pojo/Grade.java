package com.atguigu.schoolspringboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description grade
 * @author xiaochen
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_grade")
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
    * 年级id
    */
    private Integer id;

    /**
    * 年级名称
    */
    private String gradeName;

    /**
    * 年级主任
    */
    private String gradeTeacher;

    /**
    * 联系电话
    */
    private String phone;

    /**
    * 年级介绍
    */
    private String gradeIntroduction;

}
