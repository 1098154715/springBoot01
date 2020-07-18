package com.example.cxk.demo.dto;

import com.example.cxk.demo.entity.AccountLogin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ApiModel
@Data
public class AccountLoginVO {
    /**
     * 账户名称
     */
    @ApiModelProperty(value = "账户名称")

    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
