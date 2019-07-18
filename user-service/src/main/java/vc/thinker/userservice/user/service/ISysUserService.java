package vc.thinker.userservice.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import vc.thinker.userservice.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import vc.thinker.userservice.user.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List page(IPage page, SysUserVO vo);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysUser findDetail(Long id);
}
