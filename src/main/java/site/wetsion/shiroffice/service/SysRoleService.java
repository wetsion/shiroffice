package site.wetsion.shiroffice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@Transactional
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<SysRoleEntity> selectSysRoleByUserId(Long userId) {
        return sysRoleMapper.selectList(new QueryWrapper<SysRoleEntity>().eq("user_id", userId));
    }

}
