package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
public class Word implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private String wordId;
    private String wordSelf;
    private String wordComment;
    @TableField(exist = false)
    private List<WordTag> wordTagList;
    @TableField(exist = false)
    private List<Chinese> chineseList;
    @TableField(exist = false)
    private List<WordType> wordTypeList;
}
