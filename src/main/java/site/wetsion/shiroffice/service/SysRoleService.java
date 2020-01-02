package site.wetsion.shiroffice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wetsion.shiroffice.entity.SysRoleEntity;
import site.wetsion.shiroffice.mapper.SysRoleMapper;

import java.util.List;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysRoleService
 * @date 2019/12/31 5:29 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleService extends ServiceImpl<SysRoleMapper, SysRoleEntity> {

    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }

}
