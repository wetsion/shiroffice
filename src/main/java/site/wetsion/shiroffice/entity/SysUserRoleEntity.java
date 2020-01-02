package site.wetsion.shiroffice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysUserRoleEntity
 * @date 2020/1/2 2:49 PM
 */
@Data
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {

    @TableId
    private Long id;

    private Long userId;

    private Long roleId;
}
