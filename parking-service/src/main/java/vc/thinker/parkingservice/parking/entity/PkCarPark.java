package vc.thinker.parkingservice.parking.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 停车场
 * </p>
 *
 * @author HeTongHao
 * @since 2019-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PkCarPark对象", description="停车场")
public class PkCarPark implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "停车场名称")
    private String carParkName;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "总车位数")
    private Integer totalLot;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "是否带充电桩")
    private Boolean haveRecharge;

    @ApiModelProperty(value = "是否带电子支付")
    private Boolean haveAutoPay;

    @ApiModelProperty(value = "停车场类型 1:停车场 2:道路")
    private Integer parkType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean deleteIs;

    @ApiModelProperty(value = "分公司ID")
    private Long branchId;

    @ApiModelProperty(value = "预定收费模板ID")
    private Long preordainTempleteId;

    @ApiModelProperty(value = "是否开启预定")
    private Boolean preordainIs;

    @ApiModelProperty(value = "联系电话")
    private String contactNumber;

    @ApiModelProperty(value = "简介")
    private String synopsis;

    @ApiModelProperty(value = "停车场入口数量")
    private Integer pkEntranceNum;

    @ApiModelProperty(value = "停车场出口数量")
    private Integer pkExitNum;

    @ApiModelProperty(value = "状态（1、正常 2、禁用）")
    private Integer status;

    @ApiModelProperty(value = "设备数量")
    private Integer devNumber;

    @ApiModelProperty(value = "费率类型ID")
    private Long rateTypeId;

    @ApiModelProperty(value = "新能源费率类型ID")
    private Long newEnergyRateTypeId;

    @ApiModelProperty(value = "标签ID(多个 逗号,隔开)")
    private String tagIds;

    @ApiModelProperty(value = "区域id")
    private Long roadAreaId;

    @ApiModelProperty(value = "是否自营")
    private Boolean selfOperatedIs;

    @ApiModelProperty(value = "结算费率")
    private String settlementRate;

    @ApiModelProperty(value = "1:路边 2:地上 3:地下")
    private Integer position;

    @ApiModelProperty(value = "停车首价,停车场指导价")
    private String firstPrice;

    @ApiModelProperty(value = "封面url")
    private String covers;

    private String whereIs;

    @ApiModelProperty(value = "停车场code(四位数字顺序生成)")
    private String parkingAreaCode;

    @ApiModelProperty(value = "停车场完整code(分公司code+停车场code)")
    private String parkingAreaFullCode;

    @ApiModelProperty(value = "停车场key")
    private String parkingAreaKey;

    @ApiModelProperty(value = "空车位数")
    private Integer emptyLot;

    @ApiModelProperty(value = "总可预订车位数")
    private Integer scheduled;

    @ApiModelProperty(value = "空可预定车位")
    private Integer rscheduled;

    @ApiModelProperty(value = "内部总车位数量")
    private Integer internal;

    @ApiModelProperty(value = "内部空车位数")
    private Integer rinternal;

    @ApiModelProperty(value = "根据经纬度所获取的区域code（用于关联地图）")
    private String areaCode;

    @ApiModelProperty(value = "城市code")
    private String cityCode;

    @ApiModelProperty(value = "停车场最后上报时间")
    private LocalDateTime carParkLastReportTime;


}
