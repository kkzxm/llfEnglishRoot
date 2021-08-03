package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
public class Chinese implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private String chineseId;
    private String chineseInfo;
    private String chineseComment;
    
}
