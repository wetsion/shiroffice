package site.wetsion.shiroffice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysUserEntity
 * @date 2019/12/31 3:33 PM
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    private Long id;

    private String username;

    private String password;
}
