package com.example.cxk.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.cxk.demo.config.ConfigProperty;
import com.example.cxk.demo.dto.submit.AliPaySubmit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 支付接口
 */
@Api(value = "用户支付", tags = "用户支付")
@Controller
@RequestMapping(value = "/pay")
public class PayController extends BaseController {
    @Autowired
    ConfigProperty configProperty;
    @ApiOperation(value = "用户支付")
    @GetMapping("/aliPay")
    public void aliPay(AliPaySubmit paySubmit, BindingResult bindingResult) throws IOException {
        super.checkParameter(bindingResult);
        // 1 创建AlipayClient(String serverUrl, String appId, String privateKey, String format, String charset, String alipayPublicKey, String signType
        AlipayClient alipayClient =  new DefaultAlipayClient( ConfigProperty.gatewayUrl, ConfigProperty.APP_ID, ConfigProperty.APP_PRIVATE_KEY, "json", ConfigProperty.CHARSET,
                ConfigProperty.ALIPAY_PUBLIC_KEY,
                ConfigProperty.sign_type);
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest();
       String content= JSON.toJSONString(paySubmit);
        alipayRequest.setBizContent(content);
        try {
            alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

    }




}
