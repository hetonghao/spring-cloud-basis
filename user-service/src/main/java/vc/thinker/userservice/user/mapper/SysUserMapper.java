package vc.thinker.userservice.user.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import vc.thinker.userservice.user.bo.SysUserBO;
import vc.thinker.userservice.user.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import vc.thinker.userservice.user.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List page(@Param("page") IPage page, @Param("vo") SysUserVO vo);
}
