package com.hzlx.springboothuiplay.controller;

import com.hzlx.springboothuiplay.entity.SysUserInfo;
import com.hzlx.springboothuiplay.service.SysRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * springboot-hui-play
 * 2023/5/23 16:11
 * 星期二
 */
@Controller
public class sysRoleInfoController {
    @Autowired
    private SysRoleInfoService service;

    @Value("${hui_play.session-key}")
    private String sessionKey;

    @GetMapping("/getRoleAll")
    @ResponseBody
    public String RoleAll(){
        return service.getRoleAll();
    }

    @RequestMapping("/permissions")
    public String permissions(){
        return "permissions";
    }
}
