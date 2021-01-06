package com.github.admin.mapper;

import com.github.admin.module.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountMapperTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    @DisplayName("should return all accounts success from mapper")
    void queryAll() {
        List<Account> accounts = accountMapper.select(c -> c);
        accounts.forEach(account -> System.out.println(account.toString()));
        assertTrue(accounts.size() == 2);
    }
}