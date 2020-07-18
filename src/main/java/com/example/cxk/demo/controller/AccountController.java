package com.example.cxk.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.cxk.demo.config.ConfigProperty;
import com.example.cxk.demo.dto.submit.AliPaySubmit;
import com.example.cxk.demo.service.AccountLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录Controller
 */
@Api(value = "账户类接口", tags = "账户类接口")
@RequestMapping("/account")
@RestController
public class AccountController extends BaseController {
    @Autowired
    private AccountLoginService accountLoginService;
    @ApiOperation(value = "用户名+密码登录")
    @GetMapping("/login")
    public void hello(AliPaySubmit aliPaySubmit, BindingResult bindingResult, HttpServletResponse response) throws IOException {


    }
}
