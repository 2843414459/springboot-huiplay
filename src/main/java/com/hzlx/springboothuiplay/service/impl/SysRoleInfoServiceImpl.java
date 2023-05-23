package com.hzlx.springboothuiplay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzlx.springboothuiplay.comment.ResultJSON;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.SysRoleInfo;
import com.hzlx.springboothuiplay.mapper.SysMenuInfoMapper;
import com.hzlx.springboothuiplay.mapper.SysRoleInfoMapper;
import com.hzlx.springboothuiplay.service.SysRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * springboot-hui-play
 * 2023/5/23 16:14
 * 星期二
 */
@Service
public class SysRoleInfoServiceImpl extends ServiceImpl<SysRoleInfoMapper, SysRoleInfo> implements SysRoleInfoService {

    @Autowired
    private SysRoleInfoMapper sysRoleInfoMapper ;

    @Override
    public String getRoleAll() {
        return ResultJSON.success(list());
    }
}
