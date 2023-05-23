package com.hzlx.springboothuiplay.controller;

import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.SysUserInfo;
import com.hzlx.springboothuiplay.service.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 9:48
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Controller
public class SysMenuInfoController {

    @Value("${hui_play.session-key}")
    private String sessionKey;

    @Autowired
    private SysMenuInfoService sysMenuInfoService;


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/getSysMenuInfo")
    @ResponseBody
    public String showSysMenuInfo(HttpServletRequest request){
        SysUserInfo sysMenuInfo = (SysUserInfo) request.getSession().getAttribute(sessionKey);
        return sysMenuInfoService.getSysMenuInfo(sysMenuInfo);
    }

    @RequestMapping("/home")
    public String login(){
        return "home";
    }

    @RequestMapping("/getMenuList")
    @ResponseBody
    public String getMenuList(){
        return sysMenuInfoService.getMenuList();
    }
    @RequestMapping("/getMenuIdList")
    @ResponseBody
    public String getMenuIdAndTitle(){
        return sysMenuInfoService.getMenuIdList();
    }

    @PostMapping("/addMenu")
    public String addMenu(SysMenuInfo sysMenuInfo){
        sysMenuInfoService.addMenu(sysMenuInfo);
        return "home";
    }

    @RequestMapping("/changeMenu/{id}")
    public String changeMenu(@PathVariable("id") Integer id, SysMenuInfo sysMenuInfo){
        System.out.println(id);
        sysMenuInfoService.changeMenu(sysMenuInfo, id);
        return "home";
    }
}
