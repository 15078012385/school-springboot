package com.atguigu.schoolspringboot.pojo;

import lombok.Data;

@Data
public class UserPasswordDTO {
    private Integer id;
    private String password;
    private String newPassword;
}
