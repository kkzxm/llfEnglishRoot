package com.lingDream.llfEnglish.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */

@Data
@Accessors(chain = true)
@TableName(resultMap = "tagGroup")
public class TagGroup implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private String tagGroupId;//标签组Id
    private String tagGroupName;//标签组名称
    private String tagGroupComment;//标签备注
    private TagGroup tagGroupParent;//父标签组
    @TableField(exist = false)
    private Set<TagGroup> childTagGroupSet = new HashSet<>();

    public boolean addChild(TagGroup tagGroup) {
        if (tagGroup != null && this.getTagGroupId().equals(tagGroup.getTagGroupParent().getTagGroupId())) {
            return this.childTagGroupSet.add(tagGroup);
        }
        return false;
    }

    public boolean removeChild(TagGroup tagGroup) {
        if (this.getTagGroupId().equals(tagGroup.getTagGroupParent().getTagGroupId())) {
            return this.childTagGroupSet.remove(tagGroup);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagGroup tagGroup = (TagGroup) o;
        //如果Id相同,那么就认为它们是同一个
        return Objects.equals(tagGroupId, tagGroup.tagGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagGroupId, tagGroupName, tagGroupComment, tagGroupParent, childTagGroupSet);
    }
}
