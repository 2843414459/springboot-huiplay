package com.hzlx.springboothuiplay.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 11:53
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuInfoTreeVO implements Serializable {
    private Integer id;

    private Integer pid;

    private String title;

    private String icon;

    private String href;

    private String target;

    private List<SysMenuInfoTreeVO> child;
}
