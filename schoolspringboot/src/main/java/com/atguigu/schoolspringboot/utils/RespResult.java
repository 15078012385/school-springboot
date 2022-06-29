package com.atguigu.schoolspringboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespResult<T> {
    private String code;
    private String msg;
    private T data;

    public RespResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    private Integer count;

    public static RespResult success() {
        return new RespResult("200", "操作成功", null);
    }

    public static RespResult success(Object data) {
        return new RespResult("200", "操作成功", data);
    }

}
