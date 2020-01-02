package site.wetsion.shiroffice.web;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wetsion.shiroffice.util.ShiroUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weixin
 * @version 1.0
 * @CLassName UserRoleController
 * @date 2020/1/2 2:35 PM
 */
@RestController
@RequestMapping("/role")
public class UserRoleController {


    @RequestMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    public Map<String,Object> getAdminInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有管理员角色能访问的接口");
        return map;
    }

    @RequestMapping("/getUserInfo")
    @RequiresRoles("USER")
    public Map<String,Object> getUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有用户角色能访问的接口");
        return map;
    }

    @RequestMapping("/getRoleInfo")
    @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
    @RequiresUser
    public Map<String,Object> getRoleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
        return map;
    }

    @RequestMapping("/getLogout")
    @RequiresUser
    public Map<String,Object> getLogout(){
        ShiroUtil.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }

}
