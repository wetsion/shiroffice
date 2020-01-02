package site.wetsion.shiroffice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysRoleEntity
 * @date 2019/12/31 5:13 PM
 */
@Data
@TableName("sys_role")
public class SysRoleEntity {

    @TableId
    private Long id;

    private String roleName;
}
