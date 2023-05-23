package com.hzlx.springboothuiplay.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzlx.springboothuiplay.comment.ResultJSON;
import com.hzlx.springboothuiplay.entity.SysUserInfo;
import com.hzlx.springboothuiplay.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * hui-play
 * 2023/5/15 9:00
 * 星期一
 */
@Controller
public class SysUserInfoController {

    @Autowired
    private SysUserInfoService sysUserInfoService;



    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,String username,String password){
        return sysUserInfoService.login(request,username,password);
    }



    @GetMapping("/getUserAll")
    @ResponseBody
    public String getUserAll(){
        return sysUserInfoService.getUserAll();
    }

    @GetMapping("/addUserPage/{type}/{id}")
    public String goAddUserPage(@PathVariable("id") Integer id,@PathVariable("type") Integer type, Model model){
        model.addAttribute("type",type);
        SysUserInfo userInfo = sysUserInfoService.getOne(new QueryWrapper<SysUserInfo>().eq("id", id));
        if (userInfo==null) {
            userInfo = new SysUserInfo();
        }
        model.addAttribute("userInfo",userInfo);
        return "add_user";
    }


    @PostMapping("/saveUser")
    @ResponseBody
    public String saveUserInfo(SysUserInfo sysUserInfo){
        return sysUserInfoService.saveUserInfo(sysUserInfo);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUserInfo(SysUserInfo sysUserInfo){
        return sysUserInfoService.updateUser(sysUserInfo);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id){
        return sysUserInfoService.deleteUser(id);
    }

}
