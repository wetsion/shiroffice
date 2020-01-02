package site.wetsion.shiroffice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.wetsion.shiroffice.entity.SysRoleMenuEntity;
import site.wetsion.shiroffice.mapper.SysRoleMenuMapper;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysRoleMenuService
 * @date 2020/1/2 2:53 PM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleMenuService extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> {
}
