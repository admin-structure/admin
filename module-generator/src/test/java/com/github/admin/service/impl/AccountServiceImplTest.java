package com.github.admin.service.impl;

import com.github.admin.model.Account;
import com.github.admin.service.AccountService;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @version v0.1
 * @author wanglei
 */
@MybatisTest
@Import(AccountServiceImpl.class)
@ImportAutoConfiguration(PageHelperAutoConfiguration.class)
class AccountServiceImplTest {
    @Resource
    AccountService accountService;

    @Test
    @DisplayName("should add a row to database, return number of rows affected")
    void add() {
        Account account = new Account();
        account.setId(999L);
        account.setName("999");

        int rows = accountService.add(account);

        assertEquals(1, rows);
    }

    @Test
    @DisplayName("should update a row to database, return number of rows affected")
    void updateById() {
        final String replaceName = "newName";
        Account account = new Account();
        account.setId(1L);
        account.setName(replaceName);

        int rows = accountService.update(account);
        assertEquals(1, rows);

        account = accountService.query(account.getId());

        assertEquals(replaceName, account.getName());
    }

    @Test
    @DisplayName("should update a row to database, return number of rows affected")
    void updateByCondition() {
        final String newName = "newName";
        Account account = new Account();
        account.setName(newName);

        int rows = accountService.updateByCondition(newName);
        assertEquals(2, rows);

        List<Account> accounts = accountService.query(account);

        assertEquals(2, accounts.size());
    }

    @Test
    @DisplayName("should return all account from db")
    void queryAll() {
        List<Account> accounts = accountService.queryAll();

        assertEquals(2, accounts.size());
    }

    @Test
    @DisplayName("should return the 2rd page accounts from db, and the first return account id is 2")
    void queryPageHelper() {
        final int pageNum = 2, pageSize = 1;
        List<Account> accounts = accountService.queryPageHelper(pageNum, pageSize);

        assertEquals(1, accounts.size());
        assertEquals(2, accounts.get(0).getId());
    }

    @Test
    @DisplayName("should return a account, the name is 'user1'")
    void queryByCondition() {
        final String name = "user1";
        Account account = new Account();
        account.setName(name);

        List<Account> accounts = accountService.query(account);

        assertEquals(1, accounts.size());
        assertEquals(name, accounts.get(0).getName());
    }

    @Test
    @DisplayName("should delete a row from database, where id is '1', return number of rows affected")
    void deleteById() {
        final Long id = 1L;
        int rows = accountService.delete(id);

        assertEquals(1, rows);
    }

    @Test
    @DisplayName("should delete a row from database, where id name 'user1', return number of rows affected")
    void deleteByCondition() {
        final String name = "user1";
        Account account = new Account();
        account.setName(name);

        int rows = accountService.delete(account);

        assertEquals(1, rows);
    }
}