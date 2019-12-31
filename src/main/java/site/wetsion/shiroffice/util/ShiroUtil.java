package site.wetsion.shiroffice.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;
import site.wetsion.shiroffice.entity.SysUserEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * @author weixin
 * @version 1.0
 * @CLassName ShiroUtil
 * @date 2019/12/31 3:27 PM
 */
public class ShiroUtil {

    private ShiroUtil() {}

    private static RedisSessionDAO redisSessionDAO =
            SpringUtil.getBean(RedisSessionDAO.class);

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static SysUserEntity getUserInfo() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    public static void deleteCache(String username, boolean isRemoveSession) {
        Session session = null;
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        SysUserEntity sysUserEntity;
        Object attr = null;
        for (Session sessionInfo : sessions) {
            attr = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attr == null) {
                continue;
            }
            sysUserEntity = (SysUserEntity) ((SimplePrincipalCollection)attr).getPrimaryPrincipal();
            if (sysUserEntity == null) {
                continue;
            }
            if (Objects.equals(sysUserEntity.getUsername(), username)) {
                session = sessionInfo;
                break;
            }
        }
        if (session == null || attr == null) {
            return;
        }
        if (isRemoveSession) {
            redisSessionDAO.delete(session);
        }
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authenticator = securityManager.getAuthenticator();
        ((LogoutAware)authenticator).onLogout((SimplePrincipalCollection) attr);
    }
}
