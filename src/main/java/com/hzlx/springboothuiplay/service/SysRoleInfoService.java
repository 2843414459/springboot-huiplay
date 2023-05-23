package com.hzlx.springboothuiplay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.SysRoleInfo;

/**
 * springboot-hui-play
 * 2023/5/23 16:13
 * 星期二
 */
public interface SysRoleInfoService extends IService<SysRoleInfo> {
    String getRoleAll();
}
