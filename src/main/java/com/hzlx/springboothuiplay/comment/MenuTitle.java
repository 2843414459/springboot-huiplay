package com.hzlx.springboothuiplay.comment;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * springboot-hui-play
 * 2023/5/22 10:23
 * 星期一
 */
@Data
public class MenuTitle implements Serializable {
    private Object title;

    public MenuTitle(Object data) {
        this.title = data;
    }

    public MenuTitle() {
    }

    public static String success(Object data) {
        MenuTitle menuTitle = new MenuTitle(data);
        return JSON.toJSONString(menuTitle);
    }


}
