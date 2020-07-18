package com.example.cxk.demo.service;

import com.example.cxk.demo.dto.AccountLoginVO;


public interface AccountLoginService {
    AccountLoginVO getAccountLoginByUserNameAndPassword(String userName, String password);
}
