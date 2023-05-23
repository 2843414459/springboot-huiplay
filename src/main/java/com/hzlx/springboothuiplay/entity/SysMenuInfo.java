package com.hzlx.springboothuiplay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 9:43
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
@TableName("t_sys_menu_info")
public class SysMenuInfo implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("pid")
    private Integer pId;
    private String title;
    private String icon;
    private String href;
    private String target;
    private Integer sort;
    private Integer status;
    private String remark;
    private Date createTime;
    private Date updateTime;
}
