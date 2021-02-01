package com.github.admin.service;

import com.github.admin.model.Account;

import java.util.List;

/**
 * 单表查询
 *
 * @version v0.1
 * @Autheror wanglei
 */
public interface AccountService {
    int add(Account account);

    int update(Account account);
    int updateByCondition(String newName);

    List<Account> queryAll();
    List<Account> queryPageHelper(int pageNum, int pageSize);
    List<Account> query(Account account);
    Account query(Long key);

    int delete(Long id);
    int delete(Account account);
}
