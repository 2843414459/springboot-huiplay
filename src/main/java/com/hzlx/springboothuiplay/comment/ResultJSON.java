package com.hzlx.springboothuiplay.comment;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 11:36
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Data
public class ResultJSON implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    private Integer count;

    private ResultJSON(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultJSON(Integer code, String msg, Object data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count=count;
    }

    public static String success() {
        ResultJSON resultJSON = new ResultJSON(0, "success", null);
        return JSON.toJSONString(resultJSON);
    }

    public static String success(Object data) {
        ResultJSON resultJSON = new ResultJSON(0, "success", data);
        return JSON.toJSONString(resultJSON);
    }

    public static String success(Integer count,Object data) {
        ResultJSON resultJSON = new ResultJSON(0, "success", data,count);
        return JSON.toJSONString(resultJSON);
    }

    public static String error(Integer code, String msg) {
        ResultJSON resultJSON = new ResultJSON(code, msg, null);
        return JSON.toJSONString(resultJSON);
    }
}
