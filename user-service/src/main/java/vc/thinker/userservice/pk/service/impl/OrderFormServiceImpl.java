package vc.thinker.userservice.pk.service.impl;

import vc.thinker.userservice.pk.entity.OrderForm;
import vc.thinker.userservice.pk.vo.OrderFormPageVO;
import vc.thinker.userservice.pk.mapper.OrderFormMapper;
import vc.thinker.userservice.pk.service.IOrderFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-18
 */
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormMapper, OrderForm> implements IOrderFormService {

    @Override
    public List page(IPage page, OrderFormPageVO vo) {
        return baseMapper.page(page, vo);
    }
}
