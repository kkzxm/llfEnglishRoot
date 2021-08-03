package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
@TableName(value = "word_tag_info",resultMap = "wordTag")
public class WordTag implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private String wordTagId;
    private String wordTagName;
    private String tagComment;
    private TagGroup tagGroup;
    @TableField(exist = false)
    private List<Word> wordList = new ArrayList<>();
}
