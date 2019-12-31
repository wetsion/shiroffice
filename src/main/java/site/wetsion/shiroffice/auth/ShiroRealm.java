package site.wetsion.shiroffice.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import site.wetsion.shiroffice.entity.SysRoleEntity;
import site.wetsion.shiroffice.entity.SysUserEntity;
import site.wetsion.shiroffice.service.SysMenuService;
import site.wetsion.shiroffice.service.SysRoleService;
import site.wetsion.shiroffice.service.SysUserService;

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
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return null;
    }
}
