package com.example.cxk.demo.mapper;


import com.example.cxk.demo.dto.AccountLoginVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AccountLoginMapper extends com.example.cxk.demo.mapper.generator.AccountLoginMapper {

    AccountLoginVO getAccountLoginByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}