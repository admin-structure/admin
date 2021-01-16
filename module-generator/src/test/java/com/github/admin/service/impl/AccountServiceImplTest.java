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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@MybatisTest
@Import(AccountServiceImpl.class)
@ImportAutoConfiguration(PageHelperAutoConfiguration.class)
class AccountServiceImplTest {
    @Autowired
    AccountService accountService;

    @Test
    @DisplayName("should add a row to database, return number of rows affected")
    void add() {
        Account account = new Account();
        account.setId(999);
        account.setName("999");

        int rows = accountService.add(account);
        assertTrue(1 == rows);
    }

    @Test
    @DisplayName("should update a row to database, return number of rows affected")
    void updateById() {
        final String replaceName = "newName";
        Account account = new Account();
        account.setId(1);
        account.setName(replaceName);

        int rows = accountService.update(account);
        assertTrue(1 == rows);

        account = accountService.query(account.getId());
        assertTrue(account.getName().equals(replaceName));
    }

    @Test
    @DisplayName("should update a row to database, return number of rows affected")
    void updateByCondition() {
        final String newName = "newName";
        Account account = new Account();
        account.setName(newName);

        int rows = accountService.updateByCondition(newName);
        assertTrue(2 == rows);

        List<Account> accounts = accountService.query(account);
        assertTrue(2 == accounts.size());
    }

    @Test
    @DisplayName("should return all account from db")
    void queryAll() {
        List<Account> accounts = accountService.queryAll();

        assertTrue(2 == accounts.size());
    }

    @Test
    @DisplayName("should return the 2rd page accounts from db, and the first return account id is 2")
    void queryPageHelper() {
        final int pageNum = 2, pageSize = 1;
        List<Account> accounts = accountService.queryPageHelper(pageNum, pageSize);
        assertTrue(1 == accounts.size());
        assertTrue(2 == accounts.get(0).getId());
    }

    @Test
    @DisplayName("should return a account, the name is 'user1'")
    void queryByCondition() {
        final String name = "user1";
        Account account = new Account();
        account.setName(name);

        List<Account> accounts = accountService.query(account);
        assertTrue(1 == accounts.size());
        assertTrue(accounts.get(0).getName().equals(name));
    }

    @Test
    @DisplayName("should delete a row from database, where id is '1', return number of rows affected")
    void deleteById() {
        final Integer id = 1;
        int rows = accountService.delete(id);

        assertTrue(1 == rows);
    }

    @Test
    @DisplayName("should delete a row from database, where id name 'user1', return number of rows affected")
    void deleteByCondition() {
        final String name = "user1";
        Account account = new Account();
        account.setName(name);

        int rows = accountService.delete(account);

        assertTrue(1 == rows);
    }
}