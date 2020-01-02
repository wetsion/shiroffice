package site.wetsion.shiroffice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.wetsion.shiroffice.entity.SysRoleEntity;

import java.util.List;

/**
 * @author weixin
 * @version 1.0
 * @CLassName SysRoleMapper
 * @date 2019/12/31 6:02 PM
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    @Select("SELECT sr.* FROM sys_role sr\n" +
            "        LEFT JOIN sys_user_role se ON sr.id=se.role_id\n" +
            "        WHERE se.user_id = #{userId}")
    List<SysRoleEntity> selectByUserId(Long userId);
}
