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
 * @description admin
 * @date 2022-06-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 上次登录时间
     */
    private String loginTime;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 格言
     */
    private String aphorism;

}
