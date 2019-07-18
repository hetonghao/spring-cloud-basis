package vc.thinker.userservice.pk.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import vc.thinker.common.PageVO;

/**
 * <p>
 * 
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrderFormPageVO对象", description = "")
public class OrderFormPageVO extends PageVO {
}