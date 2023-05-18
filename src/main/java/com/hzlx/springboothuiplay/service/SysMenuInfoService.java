package com.hzlx.springboothuiplay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.SysUserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 9:47
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
public interface SysMenuInfoService extends IService<SysMenuInfo> {
    int addSysMenuInfo(SysMenuInfo sysMenuInfo);

    String getSysMenuInfo(SysUserInfo sysUserInfo);

    String getMenuList();

    void addMenu(SysMenuInfo sysMenuInfo);

    void changeMenu( SysMenuInfo sysMenuInfo,Integer id);
}
