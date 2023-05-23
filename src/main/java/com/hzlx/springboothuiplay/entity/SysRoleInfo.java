package com.hzlx.springboothuiplay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * springboot-hui-play
 * 2023/5/23 16:20
 * 星期二
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role_info")
public class SysRoleInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private Date createTime;
    private Integer status;
}
