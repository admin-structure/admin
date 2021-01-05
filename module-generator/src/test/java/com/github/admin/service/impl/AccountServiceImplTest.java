package com.github.admin.service.impl;

import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@MybatisTest
@Import(AccountServiceImpl.class)
class AccountServiceImplTest {
    @Resource
    private AccountService accountService;

    @Test
    @DisplayName("should return all accounts success from service")
    public void queryAllTest() {
        List<Account> accounts = accountService.queryAll();

        accounts.forEach(account -> System.out.println(account.toString()));

        assertThat(accounts.size() == 2);
    }
}