package site.wetsion.shiroffice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wetsion.shiroffice.entity.SysMenuEntity;
import site.wetsion.shiroffice.mapper.SysMenuMapper;
import java.util.List;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysMenuService
 * @date 2019/12/31 5:36 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuService extends ServiceImpl<SysMenuMapper, SysMenuEntity> {

    public List<SysMenuEntity> selectSysMenuByRoleId(Long roleId) {
        return baseMapper.selectSysMenuByRoleId(roleId);
    }
}
