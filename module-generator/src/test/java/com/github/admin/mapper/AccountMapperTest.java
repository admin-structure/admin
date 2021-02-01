package com.github.admin.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @version v0.1
 * @author wanglei
 */
@MybatisTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountMapperTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    @DisplayName("should return all accounts success from mapper")
    void queryAll() {
        assertEquals(2, accountMapper.select(c -> c).size());
    }
}