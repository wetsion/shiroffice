package site.wetsion.shiroffice.util;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * session ID 生成器
 *
 * @author weixin
 * @version 1.0
 * @CLassName ShiroSessionIdGenerator
 * @date 2019/12/31 4:50 PM
 */
public class ShiroSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        Serializable id = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", id);
    }
}
