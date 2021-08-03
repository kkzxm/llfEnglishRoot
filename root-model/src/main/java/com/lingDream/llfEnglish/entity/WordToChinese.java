package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
@TableName(value = "word_to_chinese_info",resultMap = "wordToChinese")
public class WordToChinese implements Serializable {
    private Word word;
    private Chinese chinese;
    private String wordToChineseComment;
}
