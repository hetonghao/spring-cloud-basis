package vc.thinker.userservice.pk.mapper;

import org.apache.ibatis.annotations.Param;
import vc.thinker.userservice.pk.entity.OrderForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import vc.thinker.userservice.pk.vo.OrderFormPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-17
 */
public interface OrderFormMapper extends BaseMapper<OrderForm> {
    /**
    * 根据VO分页查询
    *
    * @param page
    * @param vo
    * @return
    */
    List page(@Param("page") IPage page, @Param("vo") OrderFormPageVO vo);
}
