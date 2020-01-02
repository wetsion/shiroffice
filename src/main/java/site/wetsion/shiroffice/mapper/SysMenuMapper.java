package site.wetsion.shiroffice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.wetsion.shiroffice.entity.SysMenuEntity;

import java.util.List;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysMenuMapper
 * @date 2019/12/31 6:03 PM
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    @Select("SELECT sm.* FROM sys_menu sm\n" +
            "      LEFT JOIN sys_role_menu se ON sm.id = se.menu_id\n" +
            "      WHERE se.role_id = #{roleId}")
    List<SysMenuEntity> selectSysMenuByRoleId(Long roleId);
}
