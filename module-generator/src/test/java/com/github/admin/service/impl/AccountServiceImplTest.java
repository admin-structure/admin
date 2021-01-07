package com.github.admin.service.impl;

import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AccountServiceImpl.class)
@ImportAutoConfiguration(PageHelperAutoConfiguration.class)
class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("should return all accounts success from service")
    public void queryAllTest() {
        List<Account> accounts = accountService.queryAll();

        accounts.forEach(account -> System.out.println(account.toString()));

        assertTrue(accounts.size() == 1);
    }
}