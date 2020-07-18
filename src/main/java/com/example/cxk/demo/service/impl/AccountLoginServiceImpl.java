package com.example.cxk.demo.service.impl;

import com.example.cxk.demo.dto.AccountLoginVO;
import com.example.cxk.demo.entity.AccountLogin;
import com.example.cxk.demo.entity.AccountLoginExample;
import com.example.cxk.demo.mapper.AccountLoginMapper;
import com.example.cxk.demo.service.AccountLoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountLoginServiceImpl implements AccountLoginService {
    private final AccountLoginMapper accountLoginMapper;

    public AccountLoginServiceImpl(AccountLoginMapper accountLoginMapper) {
        this.accountLoginMapper = accountLoginMapper;
    }


    @Override
    public AccountLoginVO getAccountLoginByUserNameAndPassword(String userName, String password) {
        AccountLoginExample example=new AccountLoginExample();
        example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        AccountLoginVO accountLogins= accountLoginMapper.getAccountLoginByUserNameAndPassword(userName,password);

        return accountLogins;
    }
}
