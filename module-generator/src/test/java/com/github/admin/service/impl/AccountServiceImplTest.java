package com.github.admin.service.impl;

import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
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
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AccountServiceImpl.class)
@ImportAutoConfiguration(PageHelperAutoConfiguration.class)
class AccountServiceImplTest {
    @Resource
    private AccountService accountService;

    @Test
    @DisplayName("should return all accounts success from service")
    public void queryAllTest() {
        List<Account> accounts = accountService.queryAll();

        accounts.forEach(account -> System.out.println(account.toString()));

        assertTrue(accounts.size() == 1);
    }
}