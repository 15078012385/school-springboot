package com.atguigu.schoolspringboot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaochen
 * @description announcement
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_announcement")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 公告id
     */
    private Integer id;

    /**
     * 发布时间
     */
    private String publishTime;

    /**
     * 公告内容
     */
    private String content;

}
