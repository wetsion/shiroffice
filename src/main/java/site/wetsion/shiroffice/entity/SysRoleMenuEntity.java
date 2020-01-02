package site.wetsion.shiroffice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysRoleMenuEntity
 * @date 2020/1/2 2:51 PM
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {

    @TableId
    private Long id;

    private Long roleId;

    private Long menuId;
}
