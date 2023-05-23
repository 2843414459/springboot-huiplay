package com.hzlx.springboothuiplay.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzlx.springboothuiplay.comment.MenuTitle;
import com.hzlx.springboothuiplay.comment.ResultJSON;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.SysUserInfo;
import com.hzlx.springboothuiplay.entity.vo.SysMenuIdAndTitleVO;
import com.hzlx.springboothuiplay.entity.vo.SysMenuInfoTreeVO;
import com.hzlx.springboothuiplay.mapper.SysMenuInfoMapper;
import com.hzlx.springboothuiplay.service.SysMenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Description:
 *
 * @author: Mr、哈喽沃德
 * @Date: 2023/5/12 9:47
 * Created with IntelliJ IDEA.
 * To change this template use File | Settings | File And Code Templates.
 */
@Service
public class SysMenuInfoServiceImpl extends ServiceImpl<SysMenuInfoMapper,SysMenuInfo> implements SysMenuInfoService{
    @Autowired
    private SysMenuInfoMapper sysMenuInfoMapper;





    @Override
    public int addSysMenuInfo(SysMenuInfo sysMenuInfo) {
        return sysMenuInfoMapper.insert(sysMenuInfo);
    }
    @Override
    public String getSysMenuInfo(SysUserInfo sysUserInfo) {
        Map<String,Object> menuMap=new HashMap<>();
        Map<String,Object> homeInfo=new HashMap<>();
        homeInfo.put("title","首页");
        homeInfo.put("href","jump/welcome");
        Map<String,Object> logoInfo=new HashMap<>();
        logoInfo.put("title","惠玩儿后台管理");
        logoInfo.put("image","static/images/logo.png");
        logoInfo.put("href","");
        menuMap.put("homeInfo",homeInfo);
        menuMap.put("logoInfo",logoInfo);

        List<SysMenuInfoTreeVO> menuInfos = assembleSysMenuInfo(sysUserInfo.getId(),null);
        menuMap.put("menuInfo",menuInfos);
//        return ResultJSON.success(menuMap);
        return JSON.toJSONString(menuMap);
    }

    @Override
    public String getMenuList() {
        //做什么？ 一个是总条数，一个是总记录数
        long count = count();
        List<SysMenuInfo> list = list();
        return ResultJSON.success((int) count,list);
    }

    @Override
    public void addMenu(SysMenuInfo sysMenuInfo) {
        sysMenuInfo.setCreateTime(new Date());
        sysMenuInfo.setUpdateTime(new Date());
        sysMenuInfoMapper.insert(sysMenuInfo);
    }

    @Override
    public void changeMenu(SysMenuInfo sysMenuInfo,Integer id) {
        sysMenuInfo.setId(id);
        int count = sysMenuInfoMapper.updateById(sysMenuInfo);
    }

    @Override
    public String getMenuIdList() {
        List<SysMenuIdAndTitleVO> list = sysMenuInfoMapper.selectIdAndTitle();
        return ResultJSON.success(list);
    }


    private List<SysMenuInfoTreeVO> assembleSysMenuInfo(Integer pId){
        List<SysMenuInfoTreeVO> sysMenuInfoByPid =  sysMenuInfoMapper.getMenuListByPid(pId);
        sysMenuInfoByPid.forEach(sysMenuInfoTreeVO -> {
            sysMenuInfoTreeVO.setChild(assembleSysMenuInfo(sysMenuInfoTreeVO.getId()));
        });
        return sysMenuInfoByPid;
    }

    private List<SysMenuInfoTreeVO> assembleSysMenuInfo(Integer userId,Integer pId){
        List<SysMenuInfoTreeVO> sysMenuInfoByPid = sysMenuInfoMapper.getSysMenuInfoByPidAndPid(userId,pId);
        sysMenuInfoByPid.forEach(sysMenuInfoTreeVO -> {
            sysMenuInfoTreeVO.setChild(assembleSysMenuInfo(userId,sysMenuInfoTreeVO.getId()));
        });
        return sysMenuInfoByPid;
    }
}
