package vc.thinker.userservice.pk.service;

import vc.thinker.userservice.pk.entity.OrderForm;
import vc.thinker.userservice.pk.vo.OrderFormPageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-17
 */
public interface IOrderFormService extends IService<OrderForm> {

    /**
    * 根据VO分页查询
    *
    * @param page
    * @param vo
    * @return
    */
    List page(IPage page, OrderFormPageVO vo);
}
