package vc.thinker.userservice.pk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("pk_order_form")
@ApiModel(value = "OrderForm对象", description="")
public class OrderForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "订单编号")
    private String orderCode;

    @ApiModelProperty(value = "1:停车场订单 2: APP订单 3:标签订单 4:临停订单")
    private Integer type;

    @ApiModelProperty(value = "订单状态 5:待支付,10停车中,20欠费，30为已结束 ，40已投诉 50 已开票")
    private Integer orderStatus;

    private Long uid;

    @ApiModelProperty(value = "支付方式")
    private String paymentMark;

    private Long carParkId;

    private Long lotId;

    @ApiModelProperty(value = "停车场名称")
    private String carParkName;

    @ApiModelProperty(value = "泊位号")
    private String lotCode;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "完成时间")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "来车时间")
    private LocalDateTime comeTime;

    @ApiModelProperty(value = "走车时间")
    private LocalDateTime leaveTime;

    @ApiModelProperty(value = "停车场地址")
    private String address;

    @ApiModelProperty(value = "发起人1:app 2:收费员 3:停车场")
    private Integer createType;

    @ApiModelProperty(value = "停车费用(计费费用)")
    private String totalPrice;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @ApiModelProperty(value = "分公司ID")
    private Long branchId;

    @ApiModelProperty(value = "付费方式 1:预付费 2:后付费")
    private Integer payType;

    @ApiModelProperty(value = "1:普通用户 2:收费员 3:巡查员")
    private Integer createUserType;

    @ApiModelProperty(value = "如果是车主创建则为空")
    private String createUserCode;

    @ApiModelProperty(value = "收费类型 1:普通 2:包月 3:免费")
    private Integer carType;

    @ApiModelProperty(value = "车主手机号")
    private String userMobile;

    @ApiModelProperty(value = "管理员编号（手动抬杠管理员）")
    private String adminCode;

    @ApiModelProperty(value = "出场抬杠方式 1:自动 2:手动")
    private Integer upType;

    @ApiModelProperty(value = "入场图片")
    private String inImage;

    @ApiModelProperty(value = "出场图片")
    private String outImage;

    @ApiModelProperty(value = "入口名称")
    private String inName;

    @ApiModelProperty(value = "出口名称")
    private String outName;

    @ApiModelProperty(value = "总的实际支付金额")
    private String totalPayPrice;

    @ApiModelProperty(value = "优惠券")
    private Long userCouponId;

    @ApiModelProperty(value = "优惠券金额")
    private String couponPrice;

    @ApiModelProperty(value = "欠费金额")
    private String overPrice;

    @ApiModelProperty(value = "预付费时长")
    private Integer prePayMinute;

    @ApiModelProperty(value = "1:停车场 2:道路")
    private Integer parkType;

    @ApiModelProperty(value = "发起收费员ID")
    private Long createChargeUid;

    @ApiModelProperty(value = "退回金额")
    private String refundPrice;

    @ApiModelProperty(value = "预付费金额")
    private String prePayPrice;

    @ApiModelProperty(value = "发起收费员名称")
    private String createChargeName;

    @ApiModelProperty(value = "发起收费员工号")
    private String createChargeNo;

    private Long endChargeUid;

    @ApiModelProperty(value = "结束收费员id")
    private String endChargeName;

    @ApiModelProperty(value = "结束收费员编号")
    private String endChargeNo;

    @ApiModelProperty(value = "结束收费员手机号")
    private String endChargeMobile;

    @ApiModelProperty(value = "发起收费员手机号")
    private String createChargeMobile;

    @ApiModelProperty(value = "创建的岗位")
    private String createJobName;

    @ApiModelProperty(value = "创建的岗位code")
    private String endJobCode;

    @ApiModelProperty(value = "结束的岗位")
    private String endJobName;

    private String createJobCode;

    @ApiModelProperty(value = "是否自动拉起订单")
    private Boolean pullUpIs;

    @ApiModelProperty(value = "是否误操作")
    private Boolean mistakeOperationIs;

    @ApiModelProperty(value = "是否手动输入车牌号码")
    private Boolean handOperationIs;

    @ApiModelProperty(value = "收费员拍的照片")
    private String chargeImages;

    @ApiModelProperty(value = "是否收费")
    private Boolean chargeIs;

    @ApiModelProperty(value = "拉起次数")
    private Integer numberOfPulls;

    @ApiModelProperty(value = "费用最后更新时间")
    private LocalDateTime feeLastUpdateTime;

    @ApiModelProperty(value = "欠费补缴金额")
    private String overPayPrice;

    @ApiModelProperty(value = "补缴时间")
    private LocalDateTime overPayTime;

    @ApiModelProperty(value = "支付方式 1:现金支付 2:电子支付")
    private Integer feeType;

    @ApiModelProperty(value = "追缴类型 1:车主补缴 2:系统追缴 3:收费员追缴")
    private Integer overPayType;

    @ApiModelProperty(value = "追缴收费员信息:姓名(工号)")
    private String overPayChargeInfo;

    @ApiModelProperty(value = "应付金额 =总费用-停车券（包月或免费订单为0）")
    private String shouldPayPrice;

    @ApiModelProperty(value = "误操作人员类型2:收费员 3:巡查员")
    private Integer mistakeUserType;

    @ApiModelProperty(value = "误操作人ID")
    private Long mistakeUid;

    @ApiModelProperty(value = "停车券名称")
    private String couponName;

    @ApiModelProperty(value = "系统扣除金额(订单申诉)")
    private String systemReducePrice;

    @ApiModelProperty(value = "抵扣金额操作时间")
    private LocalDateTime reducePriceTime;

    @ApiModelProperty(value = "结束订单时车位关联的收费员")
    private Long joinChargeUid;


}