package com.hzlx.springboothuiplay.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzlx.springboothuiplay.entity.SysMenuInfo;
import com.hzlx.springboothuiplay.entity.vo.SysMenuInfoTreeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * springboot-hui-play
 * 2023/5/17 15:01
 * 星期三
 */
@Mapper
public interface SysMenuInfoMapper extends BaseMapper<SysMenuInfo> {
    List<SysMenuInfoTreeVO> getSysMenuInfoByPidAndPid(@Param("userId") Integer userId,@Param("pId") Integer pId);

    List<SysMenuInfoTreeVO> getMenuListByPid(@Param("pId") Integer pId);
}
