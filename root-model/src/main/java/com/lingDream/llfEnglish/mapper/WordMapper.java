package com.lingDream.llfEnglish.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingDream.llfEnglish.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Mapper
public interface WordMapper extends BaseMapper<Word> {
    List<Word> getWordAllInfoByTagId(String wordTagId);

    List<Word> getWordAllInfoByTagIsNull();

    List<Word> limitPage(@Param("start") Long start, @Param("size") Long size);
}
