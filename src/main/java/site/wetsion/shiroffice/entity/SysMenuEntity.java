package site.wetsion.shiroffice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysMenuEntity
 * @date 2019/12/31 5:22 PM
 */
@Data
@TableName("sys_menu")
public class SysMenuEntity {

    @TableId
    private Long id;

    private String name;

    private String perms;
}
