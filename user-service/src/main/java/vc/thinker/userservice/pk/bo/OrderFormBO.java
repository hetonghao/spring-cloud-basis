package vc.thinker.userservice.pk.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import vc.thinker.userservice.pk.entity.OrderForm;

/**
 * <p>
 * 
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrderFormBO对象", description = "")
public class OrderFormBO extends OrderForm {
}