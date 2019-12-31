package site.wetsion.shiroffice.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weixin
 * @version 1.0
 * @CLassName MyShiroExceptionHandlers
 * @date 2019/12/31 3:11 PM
 */
@ControllerAdvice
public class MyShiroExceptionHandlers {

    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public Map<String, Object> authorizationExceptionHandler() {
        Map<String, Object> map = new HashMap<>();
        map.put("403", "权限不足");
        return map;
    }
}
