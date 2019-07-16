package vc.thinker.userservice.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import vc.thinker.userservice.common.request.PageVO;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SysUserPageVO对象", description = "用户表")
public class SysUserVO extends PageVO implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty("时间")
    private LocalDateTime localDateTime;
}
