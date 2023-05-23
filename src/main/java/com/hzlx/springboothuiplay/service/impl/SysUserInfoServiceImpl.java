package com.hzlx.springboothuiplay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzlx.springboothuiplay.comment.ResultJSON;
import com.hzlx.springboothuiplay.entity.SysUserInfo;
import com.hzlx.springboothuiplay.mapper.SysUserInfoMapper;
import com.hzlx.springboothuiplay.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * hui-play
 * 2023/5/15 9:25
 * 星期一
 */
@Service
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfo> implements SysUserInfoService {
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Value("${hui_play.session-key}")
    private String sessionKey;

    @Override
    public String login(HttpServletRequest request, String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return ResultJSON.error(10011, "用户名和密码不能为空");
        }
        //根据用户名和密码查询用户对象
        SysUserInfo userInfo = sysUserInfoMapper.selectOne(new QueryWrapper<SysUserInfo>().eq("user_name", username).eq("password", password));
        if (userInfo!=null) {
            //把用户信息存放到session作用域中
            request.getSession().setAttribute(sessionKey,userInfo);
            return ResultJSON.success();
        }
        return ResultJSON.error(100012, "账号或密码错误");
    }

    @Override
    public String getUserAll() {
        return ResultJSON.success(list());
    }

    @Override
    public String saveUserInfo(SysUserInfo sysUserInfo) {
        //基础数据拼装
        sysUserInfo.setCreateTime(new Date());
        sysUserInfo.setStatus(1);
        if (save(sysUserInfo)) {
            return ResultJSON.success(sysUserInfo);
        }else {
            return ResultJSON.error(10011,"保存数据失败");
        }
    }

    @Override
    public String updateUser(SysUserInfo sysUserInfo) {
        if (updateById(sysUserInfo)){
            return ResultJSON.success();
        }else {
            return ResultJSON.error(10012,"修改用户失败");
        }
    }

    @Override
    public String deleteUser(Integer id) {
        if (removeById(id)) {
            return ResultJSON.success();
        }
        return ResultJSON.error(10013,"数据库异常，删除失败");
    }
}
