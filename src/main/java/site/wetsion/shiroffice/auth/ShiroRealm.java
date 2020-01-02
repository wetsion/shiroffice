package site.wetsion.shiroffice.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import site.wetsion.shiroffice.entity.SysMenuEntity;
import site.wetsion.shiroffice.entity.SysRoleEntity;
import site.wetsion.shiroffice.entity.SysUserEntity;
import site.wetsion.shiroffice.service.SysMenuService;
import site.wetsion.shiroffice.service.SysRoleService;
import site.wetsion.shiroffice.service.SysUserService;
import site.wetsion.shiroffice.util.ShiroUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author weixin
 * @version 1.0
 * @CLassName ShiroRealm
 * @date 2019/12/31 5:05 PM
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取授权信息
     *
     * @param principals
     * @author weixin
     * @date 11:07 AM 2020/1/2
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUserEntity sysUserEntity = (SysUserEntity) principals.getPrimaryPrincipal();
        Long userId = sysUserEntity.getId();
        Set<String> roles = new HashSet<>();
        Set<String> perms = new HashSet<>();
        List<SysRoleEntity> sysRoleEntities = sysRoleService.selectSysRoleByUserId(userId);
        for (SysRoleEntity roleEntity : sysRoleEntities) {
            roles.add(roleEntity.getRoleName());
            List<SysMenuEntity> sysMenuEntities = sysMenuService.selectSysMenuByRoleId(roleEntity.getId());
            for (SysMenuEntity sysMenuEntity : sysMenuEntities) {
                perms.add(sysMenuEntity.getPerms());
            }
        }
        authorizationInfo.setStringPermissions(perms);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUserEntity sysUserEntity = sysUserService.selectUserByName(username);
        if (sysUserEntity == null) {
            throw new AuthenticationException();
        }
        if (sysUserEntity.getState() == null || "PROHIBIT".equals(sysUserEntity.getState())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo(
                        sysUserEntity,
                        sysUserEntity.getPassword(),
                        ByteSource.Util.bytes(sysUserEntity.getSalt()),
                        getName());
        ShiroUtil.deleteCache(username, true);
        return authenticationInfo;
    }
}
