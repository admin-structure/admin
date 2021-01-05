package com.github.admin.service.impl;

import com.github.admin.mapper.AccountMapper;
import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    public List<Account> queryAll() {
        PageHelper.startPage(2, 1);

        List<Account> accounts =  accountMapper.select(c -> c);

        return accounts;
    }
}
