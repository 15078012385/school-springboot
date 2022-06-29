package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description messageMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    int countAll(Message queryParamDTO);

}
