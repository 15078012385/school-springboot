package com.atguigu.schoolspringboot.dao;

import com.atguigu.schoolspringboot.pojo.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * @description announcementMapper
 * @author xiaochen
 * @date 2022-06-22
 */
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {
    int countAll(Announcement queryParamDTO);
}
