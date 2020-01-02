package site.wetsion.shiroffice.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wetsion.shiroffice.entity.SysMenuEntity;
import site.wetsion.shiroffice.entity.SysRoleEntity;
import site.wetsion.shiroffice.entity.SysRoleMenuEntity;
import site.wetsion.shiroffice.entity.SysUserEntity;
import site.wetsion.shiroffice.service.SysMenuService;
import site.wetsion.shiroffice.service.SysRoleMenuService;
import site.wetsion.shiroffice.service.SysRoleService;
import site.wetsion.shiroffice.service.SysUserService;
import site.wetsion.shiroffice.util.ShiroUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weixin
 * @version 1.0
 * @CLassName UserMenuController
 * @date 2020/1/2 2:38 PM
 */
@RestController
@RequestMapping("/menu")
public class UserMenuController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @RequestMapping("/getUserInfoList")
    @RequiresPermissions("sys:user:info")
    public Map<String,Object> getUserInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        map.put("sysUserEntityList",sysUserEntityList);
        return map;
    }

    @RequestMapping("/getRoleInfoList")
    @RequiresPermissions("sys:role:info")
    public Map<String,Object> getRoleInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        map.put("sysRoleEntityList",sysRoleEntityList);
        return map;
    }

    @RequestMapping("/getMenuInfoList")
    @RequiresPermissions("sys:menu:info")
    public Map<String,Object> getMenuInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    @RequestMapping("/getInfoAll")
    @RequiresPermissions("sys:info:all")
    public Map<String,Object> getInfoAll(){
        Map<String,Object> map = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        map.put("sysUserEntityList",sysUserEntityList);
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        map.put("sysRoleEntityList",sysRoleEntityList);
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    @RequestMapping("/addMenu")
    public Map<String,Object> addMenu(){
        //添加管理员角色权限
        SysRoleMenuEntity sysRoleMenuEntity = new SysRoleMenuEntity();
        sysRoleMenuEntity.setMenuId(4L);
        sysRoleMenuEntity.setRoleId(1L);
        sysRoleMenuService.save(sysRoleMenuEntity);
        //清除缓存
        String username = "admin";
        ShiroUtil.deleteCache(username,false);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","权限添加成功");
        return map;
    }
}
