package com.hzlx.springboothuiplay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzlx.springboothuiplay.entity.SysUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * hui-play
 * 2023/5/15 9:25
 * 星期一
 */
public interface SysUserInfoService extends IService<SysUserInfo>  {
    /**
     * 后台管理系统的登录方法
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(HttpServletRequest request, String username, String password);
}
