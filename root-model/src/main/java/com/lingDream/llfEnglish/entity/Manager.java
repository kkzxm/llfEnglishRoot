package com.lingDream.llfEnglish.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:26
 */
@Data
@Accessors(chain = true)
public class Manager {
    @TableId(type = IdType.ASSIGN_ID)
    private String managerId;//ID
    private String name;//姓名
    private String nickName;//姓名
    private String password;//密码
    private String salt;//随机盐
    @TableField(exist = false)
    private String token;
}
