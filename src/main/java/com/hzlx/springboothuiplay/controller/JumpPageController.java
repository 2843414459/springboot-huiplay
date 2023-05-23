package com.hzlx.springboothuiplay.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.service.impl.SysMenuInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hui-play
 * 2023/5/15 11:43
 * 星期一
 */
@Controller
@RequestMapping("/jump")
public class JumpPageController {

    @Autowired
    SysMenuInfoServiceImpl sysMenuInfoService ;

    @RequestMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }

    @RequestMapping("/shenhe")
    public String snenhePage(){
        return "menus";
    }

    @RequestMapping("/menulist")
    public String menulistPage(){
        return "shenhe";
    }

    @RequestMapping("/testPage")
    public String testPage(Model model){
        return "test";
    }

    @RequestMapping("/changePage/{id}")
    public String changePage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        SysMenuInfo sysMenuInfo = sysMenuInfoService.getOne(new QueryWrapper<SysMenuInfo>().eq("id", id));
        model.addAttribute("sysMenuInfo",sysMenuInfo);
        return "change";
    }

    @GetMapping("/user_list")
    public String goUserListPage(){
        return "user_list";
    }

    @GetMapping("/role_list")
    public String goRoleListPage(){
        return "role_list";
    }


}
