package com.example.cxk.demo.dto.submit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.validation.constraints.NotBlank;

/**
 * @author cxk
 * @date 2020/7/15 10:29
 */
@ApiModel(value = "支付提交实体类")
@Data
public class AliPaySubmit {

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    @NotBlank(message = "订单号不能为空")
    private String out_trade_no;

    /**
     * 付款金额
     */
    @ApiModelProperty(value = "付款金额")
    @NotBlank(message = "付款金额不能为空")
    private String total_amount;

    /**
     * 订单描述
     */
    @ApiModelProperty(value = "订单描述")
    @NotBlank(message = "订单描述")
    private String subject;

}
