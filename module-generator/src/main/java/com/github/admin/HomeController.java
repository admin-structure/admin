package com.github.admin;

import com.github.admin.module.Account;
import com.github.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v0.1
 * @Autheror wanglei
 */
@RestController("/api")
public class HomeController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public @ResponseBody
    List<Account> getAllAccount() {
        accountService.queryAll().forEach(a -> System.out.println(a.toString()));
        return accountService.queryAll();
    }
}
