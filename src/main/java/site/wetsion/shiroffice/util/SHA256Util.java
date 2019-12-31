package site.wetsion.shiroffice.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SHA256Util
 * @date 2019/12/31 3:16 PM
 */
public class SHA256Util {

    private SHA256Util() {}

    public static final String HASH_NAME = "SHA-256";

    public static final int HASH_LOOP_COUNT = 15;

    /**
     * 加密
     *
     * @param password 源密码
     * @param salt 盐值
     * @author weixin
     * @date 3:20 PM 2019/12/31
     * @return java.lang.String
     **/
    public static String sha256(String password, String salt) {
        return new SimpleHash(HASH_NAME, password, salt, HASH_LOOP_COUNT).toString();
    }
}
