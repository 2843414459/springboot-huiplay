package com.hzlx.springboothuiplay.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * springboot-hui-play
 * 2023/5/22 11:53
 * 星期一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuIdAndTitleVO implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String title;
}
