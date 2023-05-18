package com.hzlx.springboothuiplay.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * hui-play
 * 2023/5/15 8:58
 * 星期一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_sys_user_info")
public class SysUserInfo implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private String imgUrl;
    private Date createTime;
    private Integer status;
}
