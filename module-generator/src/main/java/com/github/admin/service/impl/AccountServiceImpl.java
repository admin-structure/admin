package com.github.admin.service.impl;

import com.github.admin.mapper.AccountDynamicSqlSupport;
import com.github.admin.mapper.AccountMapper;
import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import com.github.pagehelper.PageHelper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * 单表查询
 *
 * @version v0.1
 * @Autheror wanglei
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public int add(Account account) {
        return accountMapper.insert(account);
    }

    /**
     * use SelectDSLCompleter, for simple update
     * @param account
     * @return
     */
    @Override
    public int update(Account account) {
        return accountMapper.update(c -> c.set(AccountDynamicSqlSupport.name).equalTo(account.getName())
                .where(AccountDynamicSqlSupport.id, isEqualTo(account.getId())));
    }

    /**
     * use statementProvider,
     * @param newName
     * @return
     */
    @Override
    public int updateByCondition(String newName) {
        UpdateStatementProvider updateStatement = SqlBuilder.update(AccountDynamicSqlSupport.account)
                .set(AccountDynamicSqlSupport.name).equalTo(newName)
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return accountMapper.update(updateStatement);
    }

    public List<Account> queryAll() {
        List<Account> accounts = accountMapper.select(c -> c);

        return accounts;
    }

    @Override
    public List<Account> queryPageHelper(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Account> accounts = accountMapper.select(c -> c);

        return accounts;
    }

    @Override
    public List<Account> query(Account account) {
        return accountMapper.select(c -> c.where(AccountDynamicSqlSupport.name, isLike("%" + account.getName())));
    }

    /**
     * @param id
     * @return Null Account
     */
    @Override
    public Account query(Integer id) {
        Optional<Account> account = accountMapper.selectOne(c -> c.where(AccountDynamicSqlSupport.id, isEqualTo(id)));

        return account.orElseGet(Account::new);
    }

    @Override
    public int delete(Integer id) {
        return accountMapper.delete(c -> c.where(AccountDynamicSqlSupport.id, isEqualTo(id)));
    }

    @Override
    public int delete(Account account) {
        return accountMapper.delete(c -> c.where(AccountDynamicSqlSupport.name, isEqualTo(account.getName())));
    }
}
