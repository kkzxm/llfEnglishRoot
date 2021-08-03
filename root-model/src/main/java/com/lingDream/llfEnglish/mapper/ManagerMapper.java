package com.lingDream.llfEnglish.mapper;

import com.lingDream.llfEnglish.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:28
 */
@Mapper
public interface ManagerMapper {
    Manager login(Manager manager);
}
