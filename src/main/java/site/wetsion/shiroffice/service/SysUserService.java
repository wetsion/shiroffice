package site.wetsion.shiroffice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wetsion.shiroffice.entity.SysUserEntity;
import site.wetsion.shiroffice.mapper.SysUserMapper;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysUserService
 * @date 2019/12/31 5:07 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserService extends ServiceImpl<SysUserMapper, SysUserEntity> {

    public SysUserEntity selectUserByName(String name) {
        return baseMapper.selectOne(
                new QueryWrapper<SysUserEntity>().eq("username", name));
    }
}
