package vc.thinker.userservice.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import vc.thinker.userservice.user.bo.SysUserBO;
import vc.thinker.userservice.user.entity.SysUser;
import vc.thinker.userservice.user.mapper.SysUserMapper;
import vc.thinker.userservice.user.service.IParkingService;
import vc.thinker.userservice.user.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vc.thinker.userservice.user.vo.SysUserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private IParkingService parkingService;

    @Override
    public List page(IPage page, SysUserVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public SysUser findDetail(Long id) {
        count();
        Long xx = System.currentTimeMillis();
        System.out.println(xx);
        parkingService.detail(id);
        System.out.println(System.currentTimeMillis() - xx);
        return getById(id);
    }
}
